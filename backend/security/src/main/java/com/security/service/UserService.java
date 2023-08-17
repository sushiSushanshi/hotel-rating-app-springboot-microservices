package com.security.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.entity.User;
import com.security.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userCredentialsRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	public User addUser(User user) {
		String randomId=UUID.randomUUID().toString();
		user.setUserId(randomId);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userCredentialsRepo.save(user);
	}
	
	public String generateToken(String username) {
		return jwtService.generateToken(username);
	}
	
	public void validateToken(String token) {
		jwtService.validToken(token);
	}
}
