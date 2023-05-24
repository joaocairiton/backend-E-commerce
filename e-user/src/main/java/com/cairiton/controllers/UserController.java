package com.cairiton.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cairiton.model.User;
import com.cairiton.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
	
	
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> listar() {
		return userRepository.findAll();
	}
	

}
