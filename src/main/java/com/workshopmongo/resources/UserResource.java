package com.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria", "maria@email.com.br");
		User alex = new User("2", "Alex", "alex@email.com.br");
		List<User> lista = new ArrayList<>();
		lista.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(lista);
		
	}
}
