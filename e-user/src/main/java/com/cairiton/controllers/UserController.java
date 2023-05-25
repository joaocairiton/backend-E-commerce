package com.cairiton.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cairiton.model.User;
import com.cairiton.repository.UserRepository;
import com.cairiton.services.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserRepository userRepository;
	private UserService userService;
	
	

	@GetMapping
	public List<User> listar() {
		return userRepository.findAll();
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> Buscar(@PathVariable Long userId) {

		return userRepository.findById(userId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User adicionar(@Valid @RequestBody User user) {
		return userService.salvar(user);
	}
	
	
	@PutMapping("/{userId}")
	public ResponseEntity<User> atualizar(@PathVariable Long userId, @Valid @RequestBody User user) {
		
		if (!userRepository.existsById(userId)) {
			return ResponseEntity.notFound().build();
		}
		user.setId(userId);
		user = userService.salvar(user);
		
		return ResponseEntity.ok(user);
		
	}
	
	
	
	

}
