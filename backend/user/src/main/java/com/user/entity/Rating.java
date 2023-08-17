package com.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
	private String ratingId;
	private String hotelId;
	private String userId;
	private int rating;
	private String feedback;
	
	private Hotel hotel;
}
