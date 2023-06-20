package com.cairiton.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cairiton.model.Rol;
import com.cairiton.model.User;
import com.cairiton.model.UserRol;
import com.cairiton.repository.UserRepository;
import com.cairiton.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping
	public List<User> listUsers() {	
		return userRepository.findAll();

	}

	 @GetMapping("/{username}")
	    public User getuser(@PathVariable("username") String username){
	        return userService.getUser(username);
	    }

	 @PostMapping("/")
	 public User saveUser(@RequestBody User user) throws Exception{
	        user.setPerfil("default.png");
	        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
	        Set<UserRol> userRoles = new HashSet<>();

	        Rol rol = new Rol();
	        rol.setRolId(2L);
	        rol.setRolName("NORMAL");

	        UserRol userRol = new UserRol();
	        userRol.setUser(user);
	        userRol.setRol(rol);

	        userRoles.add(userRol);
	        return userService.saveUser(user,userRoles);
	    }
	

		 
		 @PutMapping("/{userId}")
			public ResponseEntity<User> updateUser(@PathVariable Long userId,@Valid @RequestBody User user){
				
				if (!userRepository.existsById(userId)) {
					return ResponseEntity.notFound().build();
				}
				user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
				
				Set<UserRol> userRoles = new HashSet<>();

		        Rol rol = new Rol();
		        rol.setRolId(2L);
		        rol.setRolName("NORMAL");
		        
		        UserRol userRol = new UserRol();
		        userRol.setUser(user);
		        userRol.setRol(rol);

		        
				user.setId(userId);
				user = userRepository.save(user);
				
				userRoles.add(userRol);
				return ResponseEntity.ok(user);
			}
	
		@DeleteMapping("/{userId}")
		public ResponseEntity<Void> delete(@PathVariable Long userId) {
	
			if (!userRepository.existsById(userId)) {
				return ResponseEntity.notFound().build();
			}
			userService.deleteUser(userId);
			return ResponseEntity.noContent().build();
	
		}

	

}
