package com.cairiton;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cairiton.model.Rol;
import com.cairiton.model.User;
import com.cairiton.model.UserRol;
import com.cairiton.services.UserService;

@SpringBootApplication
public class EUserApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(EUserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * User user = new User();
		 * 
		 * user.setName("joao cairiton"); user.setUsername("joao");
		 * user.setPassword(bCryptPasswordEncoder.encode("12345"));
		 * user.setEmail("joao@gmail.com"); user.setTelefone("912234556");
		 * user.setPerfil("foto.png");
		 * 
		 * Rol rol = new Rol(); rol.setRolId(1L); rol.setRolName("ADMIN");
		 * 
		 * Set<UserRol> userRoles = new HashSet<>(); UserRol userRol = new UserRol();
		 * userRol.setRol(rol); userRol.setUser(user); userRoles.add(userRol);
		 * 
		 * User savedUser = userService.saveUser(user, userRoles);
		 * System.out.println(savedUser.getUsername());
		 */

	}

}