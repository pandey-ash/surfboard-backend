package com.assessment.surfboard.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "meeting")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_meeting_id")
    private Integer id;

    @NotNull(message = "topic is required")
    @Size(min = 1, message = "topic field cannot be empty")
    private String topic;

    @NotNull(message = "description is required")
    @Size(min = 1, message = "description field cannot be empty")
    private String description;

    @Column(name = "is_started")
    private char isStarted;

    @Column(name = "")
    @JsonProperty("")
    private Date startTime;

    @Column(name = "")
    @JsonProperty("")
    private Date estimateEndTime;

    @Column(name = "")
    @JsonProperty("")
    private String images;

    @ManyToOne
    @JsonIgnore()
    @JoinColumn(name = "fk_user_id")
    private User user;

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
    private Set<Topic> topics;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    public Meeting() {
        createdDate = new Date();
        modifiedDate = new Date();
    }

    public Meeting(Integer id, String topic, String description, char isStarted, Date startTime, Date estimateEndTime, String images, User user) {
        this.id = id;
        this.topic = topic;
        this.description = description;
        this.isStarted = isStarted;
        this.startTime = startTime;
        this.estimateEndTime = estimateEndTime;
        this.images = images;
        this.user = user;
        this.createdDate = new Date();
        this.modifiedDate = new Date();
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

    public char getIsStarted() {
        return isStarted;
    }

    public void setIsStarted(char isStarted) {
        this.isStarted = isStarted;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEstimateEndTime() {
        return estimateEndTime;
    }

    public void setEstimateEndTime(Date estimateEndTime) {
        this.estimateEndTime = estimateEndTime;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }

    public void addTopic(Topic topic) {
        if(topics == null)
            topics = new HashSet<>();
        topics.add(topic);
        topic.setMeeting(this);
    }
}
