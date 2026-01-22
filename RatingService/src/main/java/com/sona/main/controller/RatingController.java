package com.sona.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sona.main.entity.Rating;
import com.sona.main.service.RatingServices;

@RestController
@RequestMapping("/api/rating")
public class RatingController {
	
	@Autowired
	private RatingServices services;


	@PostMapping("/addrating")
	public ResponseEntity<Rating> addRating(@RequestBody Rating rating) {
		Rating newRating = (Rating) services.addRating(rating);
		return new ResponseEntity<>(newRating, HttpStatus.CREATED);
	}
	
	@GetMapping("/getratingbyuserid/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
		List<Rating> ratings = (List<Rating>) services.findByUserId(userId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
 }
	
	 @GetMapping("/getratingbyhotelid/{hotelId}")
	    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
		 List<Rating> ratings = (List<Rating>) services.findByHotelId(hotelId);
	        return new ResponseEntity<>(ratings, HttpStatus.OK);
	 }
	
}
