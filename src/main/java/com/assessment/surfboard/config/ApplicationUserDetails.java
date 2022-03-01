package com.assessment.surfboard.config;

import com.assessment.surfboard.entity.SecurityUser;
import com.assessment.surfboard.entity.User;
import com.assessment.surfboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationUserDetails implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = userRepository.findByUsername(username);
        if(users.size() < 1)
            throw new UsernameNotFoundException("Details not found for the user");
        return new SecurityUser(users.get(0));
    }
}
