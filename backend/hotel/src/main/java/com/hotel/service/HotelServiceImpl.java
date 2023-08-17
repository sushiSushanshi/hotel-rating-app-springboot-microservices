package com.hotel.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Hotel;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repository.HotelRepo;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel addHotel(Hotel hotel) {
		String random_id = UUID.randomUUID().toString();
		hotel.setId(random_id);
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getHotelById(String id) {
		
		return hotelRepo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("hotel not found with id : "+id));
	}

}
