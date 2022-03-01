package com.assessment.surfboard.repository;

import com.assessment.surfboard.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Integer> {
}
