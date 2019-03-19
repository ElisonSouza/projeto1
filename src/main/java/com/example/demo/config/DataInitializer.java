package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		createUser("Elison1", "elison1@");
		createUser("Elison2", "elison2@");
		createUser("Elison3", "elison3@");

		User user = userRepository.findByNames("Elison2");

		System.out.println(user.getName());
	}

	public void createUser(String name, String email) {
		User user = new User(name, email);
		userRepository.save(user);
	}

}
