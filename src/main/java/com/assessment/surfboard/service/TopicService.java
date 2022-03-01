package com.assessment.surfboard.service;

import com.assessment.surfboard.entity.Topic;
import com.assessment.surfboard.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public void createOrUpdateTopic(Topic topic) {
        topicRepository.save(topic);
    }
}
