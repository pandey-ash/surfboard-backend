package com.assessment.surfboard.service;

import com.assessment.surfboard.entity.User;
import com.assessment.surfboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserFromUsername(String username) {
        List<User> users = userRepository.findByUsername(username);
        if(users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    public User createOrUpdateUser(User user) {
        return userRepository.save(user);
    }
}
