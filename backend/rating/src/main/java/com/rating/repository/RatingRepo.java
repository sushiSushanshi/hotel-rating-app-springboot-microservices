package com.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rating.entity.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating, String>{
	List<Rating> findByUserId(String user_id);
	List<Rating> findByHotelId(String hotel_id);
}
