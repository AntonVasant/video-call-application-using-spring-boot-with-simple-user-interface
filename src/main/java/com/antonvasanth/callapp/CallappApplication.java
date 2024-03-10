package com.antonvasanth.callapp;

import com.antonvasanth.callapp.user.User;
import com.antonvasanth.callapp.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CallappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallappApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(UserService userService)
	{
		return args -> {
			userService.register(User.builder().userName("John").email("john@gmail.com").password("2345").build());
			userService.register(User.builder().userName("Bob").email("bob@gmail.com").password("12345").build());
			userService.register(User.builder().userName("Jack").email("jack@gmail.com").password("123456").build());
		};
	}

}
