package com.rating.service;

import java.util.List;

import com.rating.entity.Rating;

public interface RatingService {
	//create rating
	Rating createRating(Rating rating);
	
	//get all ratings
	List<Rating> getAllRatings();
	
	//get all ratings by user_id
	List<Rating> getAllRatingsByUserId(String user_id);
	
	//get all ratings by hotel_id
	List<Rating> getAllRatingByHotelId(String hotel_id);
}
