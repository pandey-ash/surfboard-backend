package com.assessment.surfboard.service;

import com.assessment.surfboard.entity.Meeting;
import com.assessment.surfboard.entity.Topic;
import com.assessment.surfboard.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    public List<Meeting> getAllMeetingDetails() {
        return meetingRepository.findAll();
    }

    @Transactional
    public Set<Topic> getMeetingTopics(Integer id) {
        Optional<Meeting> meetingOptional = meetingRepository.findById(id);
        if(meetingOptional.isPresent())
            return meetingOptional.get().getTopics();
        return new HashSet<Topic>();
    }

    public Meeting getMeetingDetail(Integer id) {
        Optional<Meeting> meetingOptional = meetingRepository.findById(id);
        if(meetingOptional.isPresent())
            return meetingOptional.get();
        return null;
    }

    public void createOrUpdateMeeting(Meeting meeting) {
        meetingRepository.save(meeting);
    }
}
