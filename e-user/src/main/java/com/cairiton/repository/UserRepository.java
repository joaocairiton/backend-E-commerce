package com.cairiton.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cairiton.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	 public User findByUsername(String username);
	
	List<User> findByName(String name);
	
	List<User> findByNameContaining(String name);
	
	Optional<User> findByEmail(String email);
	


}
