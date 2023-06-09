package com.cairiton.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cairiton.model.User;
import com.cairiton.model.UserRol;
import com.cairiton.repository.RolRepository;
import com.cairiton.repository.UserRepository;
import com.cairiton.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private RolRepository rolRepository;

	@Override
	public User saveUser(User user, Set<UserRol> userRoles) throws Exception {
		User userLocal = userRepository.findByUsername(user.getUsername());
		if(userLocal != null){
            System.out.println("User already exists");
            throw new Exception("The user is already present");
        }else{
            for(UserRol userRol:userRoles){
                rolRepository.save(userRol.getRol());
            }
            user.getUserRoles().addAll(userRoles);
            userLocal = userRepository.save(user);
        }
		return userLocal;
	}

	@Override
	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
		
	}

}
