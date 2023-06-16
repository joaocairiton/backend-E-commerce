package com.cairiton.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.cairiton.model.User;
import com.cairiton.model.UserRol;

@Service
public interface UserService {


	public User saveUser(User user, Set<UserRol> userRoles) throws Exception;

    public User getUser(String username);

    public void deleteUser(Long userId);
}
