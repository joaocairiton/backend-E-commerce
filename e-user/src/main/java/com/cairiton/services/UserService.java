package com.cairiton.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.exception.EcommerceException;
import com.cairiton.model.User;
import com.cairiton.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	private UserRepository userRepository;

	public User buscar(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new EcommerceException("Usuario não encontrado"));

	}

	@Transactional
	public User salvar(User user) {

		boolean emailEmUso = userRepository.findByEmail(user.getEmail()).stream()
				.anyMatch(userExistente -> !userExistente.equals(user));
		if (emailEmUso) {
			throw new EcommerceException("E-mail já está cadastrado! ");

		}

		return userRepository.save(user);

	}

	@Transactional
	public void remover(Long userId) {
		userRepository.deleteById(userId);

	}

}
