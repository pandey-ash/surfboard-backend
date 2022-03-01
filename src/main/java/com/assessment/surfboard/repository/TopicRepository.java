package com.assessment.surfboard.repository;

import com.assessment.surfboard.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
}
