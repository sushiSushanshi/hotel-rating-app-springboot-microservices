package com.hotel.service;

import java.util.List;

import com.hotel.entity.Hotel;

public interface HotelService {
	Hotel addHotel(Hotel hotel);
	List<Hotel> getAllHotels();
	Hotel getHotelById(String id);
}
