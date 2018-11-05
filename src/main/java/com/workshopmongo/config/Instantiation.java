package com.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workshopmongo.domain.User;
import com.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		User maria = new User(null, "Maria", "maria@email");
		User alex = new User(null, "Alex", "alex@gmail.com");
		User pedro = new User(null, "Pedro", "pedro@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, pedro));
	}

}
