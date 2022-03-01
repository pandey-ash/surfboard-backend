package com.assessment.surfboard;

import com.assessment.surfboard.entity.Meeting;
import com.assessment.surfboard.entity.User;
import com.assessment.surfboard.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class SurfboardApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
		User user = new User();
		user.setFirstName("Ashish");
		user.setLastName("Pandey");
		user.setUsername("ashish@gmail.com");
		user.setPassword("123456");

		Meeting meeting = new Meeting();
		meeting.setTopic("Testing");
		meeting.setDescription("Testing");

		user.addMeeting(meeting);

		userRepository.save(user);
	}

	@Test
	@Transactional
	void getData() {
		List<User> users = userRepository.findByUsername("ashish1@gmail.com");
		User user = users.get(0);
		System.out.println(user.getFirstName());

		for(Meeting meeting : user.getMeetings()) {
			System.out.println(meeting.getTopic());
		}

	}

}
