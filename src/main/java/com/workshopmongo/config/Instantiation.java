package com.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workshopmongo.domain.Post;
import com.workshopmongo.domain.User;
import com.workshopmongo.dto.AuthorDTO;
import com.workshopmongo.repository.PostRepository;
import com.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		userRepository.deleteAll();
		postRepository.deleteAll();
		User maria = new User(null, "Maria", "maria@email");
		User alex = new User(null, "Alex", "alex@gmail.com");
		User pedro = new User(null, "Pedro", "pedro@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, pedro));
		
		Post post1 = new Post("null", sdf.parse("07/11/2-18"), "Partiu viagem", "Vou viajar para São Paulo, abraços", new AuthorDTO(maria));
		Post post2 = new Post("null", sdf.parse("07/11/2-18"), "Bom dia", "tenha um ótimo dia", new AuthorDTO(pedro));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
