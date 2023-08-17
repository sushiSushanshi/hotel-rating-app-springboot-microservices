package com.user.service;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.entity.Rating;
import com.user.entity.User;
import com.user.exception.ResourceNotFoundException;
import com.user.external.service.RatingService;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	private RatingService ratingService;
	

	@Override
	public User addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		String randomId=UUID.randomUUID().toString();
		user.setUserId(randomId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(String userId) {
		//with rest template
		//List<Rating> rating1 = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+userId, ArrayList.class);
		
		List<Rating> rating = ratingService.getAllRatingByUser(userId);
		User user = userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("No user found with this id"));

		user.setRating(rating);
		return user;
	}

	@Override
	public void deleteUserbyId(String userId) {
		userRepo.deleteById(userId);
		
	}

	@Override
	public User updateUserById(String userId) {
		return null;
	}

}
