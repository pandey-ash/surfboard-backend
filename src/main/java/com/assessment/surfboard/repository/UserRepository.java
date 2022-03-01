package com.assessment.surfboard.repository;

import com.assessment.surfboard.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends PagingAndSortingRepository<User, UUID> {

    public List<User> findByUsername(String username);
}
