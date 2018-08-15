package com.sda.forum;

import com.sda.forum.entities.User;
import com.sda.forum.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ForumApplication {

	public static void main(String[] args) {
		ApplicationContext ap = SpringApplication.run(ForumApplication.class, args);

		UserService userService = ap.getBean("userService",UserService.class);

		User user = userService.readUser(1);

		System.out.println(user);
		userService.updateUserPostsNumber(user,200);

		System.out.println(userService.readUser(1));



	}

}
