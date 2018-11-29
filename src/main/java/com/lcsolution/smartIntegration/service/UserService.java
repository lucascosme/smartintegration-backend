package com.lcsolution.smartIntegration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcsolution.smartIntegration.model.User;
import com.lcsolution.smartIntegration.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User getUserByUserName(String username) {
		return userRepository.findByUsername(username);
	}
}
