package com.assessment.surfboard.controller;

import com.assessment.surfboard.entity.Meeting;
import com.assessment.surfboard.entity.Topic;
import com.assessment.surfboard.entity.User;
import com.assessment.surfboard.service.MeetingService;
import com.assessment.surfboard.service.TopicService;
import com.assessment.surfboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@RestController
public class HomeController {

    @Autowired
    private MeetingService meetingService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public ResponseEntity<List<Meeting>> getAllMeetings() {
        List<Meeting> meetings = meetingService.getAllMeetingDetails();
        return new ResponseEntity<List<Meeting>>(meetings, HttpStatus.OK);
    }

    @GetMapping("/login-user")
    public ResponseEntity loginUser() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/login-check")
    public ResponseEntity isUserLoggedIn() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/meeting/{id}")
    public ResponseEntity<Set<Topic>> getMeetingTopics(@PathVariable int id) {
        Set<Topic> topics = meetingService.getMeetingTopics(id);
        return new ResponseEntity<Set<Topic>>(topics, HttpStatus.OK);
    }

    @PostMapping("/create-user")
    public ResponseEntity createUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createOrUpdateUser(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/create-meeting")
    public  ResponseEntity createMeeting(Principal principal, @RequestBody Meeting meeting) {
        String username = principal.getName();
        User user = userService.getUserFromUsername(username);
        user.addMeeting(meeting);
        meetingService.createOrUpdateMeeting(meeting);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/create-meeting-topic")
    public  ResponseEntity createMeetingTopic(@RequestParam("meetingId") Integer meetingId, @RequestBody Topic topic) {
        Meeting meeting = meetingService.getMeetingDetail(meetingId);
        meeting.addTopic(topic);
        topicService.createOrUpdateTopic(topic);
        return new ResponseEntity(HttpStatus.CREATED);
    }



}
