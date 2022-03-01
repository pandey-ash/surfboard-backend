package com.assessment.surfboard.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_topic_id")
    private Integer id;

    @NotNull(message = "topic is required")
    @Size(min = 1, message = "topic field cannot be empty")
    private String topic;

    @NotNull(message = "description is required")
    @Size(min = 1, message = "description field cannot be empty")
    private String description;

    @Column(name = "time_estimate")
    private Integer timeEstimate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fk_meeting_id")
    private Meeting meeting;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    public Topic() {
        createdDate = new Date();
        modifiedDate = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTimeEstimate() {
        return timeEstimate;
    }

    public void setTimeEstimate(Integer timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
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
}
