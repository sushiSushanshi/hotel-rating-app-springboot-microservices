package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.dto.AuthRequest;
import com.security.entity.User;
import com.security.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	@Autowired
	private UserService userCredentialService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public User addUser(@RequestBody User user) {
		return userCredentialService.addUser(user);
	}
	
	@PostMapping("/token")
	public String generateToken(@RequestBody AuthRequest authRequest) {
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
		if(authenticate.isAuthenticated()) {
			return userCredentialService.generateToken(authRequest.getUsername());
		}else {
			throw new RuntimeException("invalid access");
		}
	}
	
	@GetMapping("/validate")
	public String validateToken(String token) {
		userCredentialService.validateToken(token);
		return "token validated";
	}
}
