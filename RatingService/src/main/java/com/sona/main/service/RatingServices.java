package com.sona.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sona.main.entity.Rating;
import com.sona.main.repository.RatingRepository;

@Service
public class RatingServices {

	@Autowired
	private RatingRepository repository;

	public Rating addRating(Rating rating) {
		return repository.save(rating);	
	}

	  public List<Rating> findByHotelId(String hotelId) {
	        return repository.findByHotelId(hotelId);
	    }

	public List<Rating> findByUserId(String userId) {
		return repository.findByUserId(userId);
	}
	
	
}
