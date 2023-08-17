package com.rating.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.entity.Rating;
import com.rating.repository.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepo ratingRepo;
	

	@Override
	public Rating createRating(Rating rating) {
		String randomId = UUID.randomUUID().toString();
		rating.setRatingId(randomId);
		Rating r1 = ratingRepo.save(rating);
		return r1;
	}

	@Override
	public List<Rating> getAllRatings() {
		
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getAllRatingsByUserId(String userId) {
		
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllRatingByHotelId(String hotelId) {
		
		return ratingRepo.findByHotelId(hotelId);
	}

}
