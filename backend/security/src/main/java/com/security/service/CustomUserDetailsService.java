package com.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.security.config.CustomUserDetails;
import com.security.entity.User;
import com.security.repository.UserRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepo userCredentialsRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> credential = userCredentialsRepo.findByName(username);
		return credential.map(CustomUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("user not found with name "+username));
	}

}
