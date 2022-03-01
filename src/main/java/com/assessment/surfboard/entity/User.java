package com.assessment.surfboard.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "pk_user_id", updatable = false, nullable = false, length = 36)
    @JsonProperty("")
    @Type(type = "uuid-char")
    private UUID id;

    @NotNull(message = "first_name is required")
    @Size(min = 1, message = "first_name field cannot be empty")
    @Column(name = "first_name")
    @JsonProperty("first_name")
    private String firstName;

    @NotNull(message = "last_name is required")
    @Size(min = 1, message = "last_name field cannot be empty")
    @Column(name = "last_name")
    @JsonProperty("last_name")
    private String lastName;

    @NotNull(message = "username is required")
    @Size(min = 1, message = "username field cannot be empty")
    @Pattern(regexp = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$", message = "Username should be email address")
    private String username;

    @NotNull(message = "password is required")
    @Size(min = 1, message = "password field cannot be empty")
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    @Column(name = "created_date")
    @JsonProperty(value =  "account_created", access = Access.READ_ONLY)
    private Date createdDate;

    @Column(name = "modified_date")
    @JsonProperty(value =  "account_updated", access = Access.READ_ONLY)
    private Date modifiedDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Meeting> meetings;

    public User()
    {
        createdDate = new Date();
        modifiedDate = new Date();
        meetings = new HashSet<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Set<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(Set<Meeting> meetings) {
        this.meetings = meetings;
    }

    public void addMeeting(Meeting meeting) {
        if(meetings == null)
            meetings = new HashSet<>();
        meetings.add(meeting);
        meeting.setUser(this);
    }
}