package com.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workshopmongo.domain.Post;
import com.workshopmongo.domain.User;
import com.workshopmongo.dto.AuthorDTO;
import com.workshopmongo.dto.CommentDTO;
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
		
		CommentDTO c1 = new CommentDTO("Boa Viagem, mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Boa Viagem, mano!", sdf.parse("21/03/2018"), new AuthorDTO(pedro));
		CommentDTO c3 = new CommentDTO("Boa Viagem, mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		
		
		post1.getComentarios().addAll(Arrays.asList(c1, c2));
		post2.getComentarios().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
