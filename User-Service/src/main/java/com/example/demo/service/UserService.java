package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Rating;
import com.example.demo.entity.User;
import com.example.demo.externalservice.HotelService;
import com.example.demo.repository.UserRepository;
import com.netflix.discovery.converters.Auto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	
    public User saveUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

 
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

  
    public User getUser(String userId) {
        User user =  userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        //http://localhost:8083/api/rating/getratingbyuserid/11be22ef-d529-4adf-9dca-51f6c1aced97
        Rating[] ratingOfUser = restTemplate.getForObject(
                "http://RATINGSERVICE/api/rating/getratingbyuserid/" + userId,
                Rating[].class
        );
        
        List<Rating> ratings =  Arrays.stream(ratingOfUser).toList();
        
        logger.info("{}", ratingOfUser);
        
        List<Rating> ratingList = ratings.stream().map( rating -> {
        		//api call to hotel service to get hotel 
        		// http://localhost:8082/hotel/gethotel/1bd4513d-5209-48fc-ab4f-99a0f9d55dd5
        		 //ResponseEntity<Hotel> entity =  restTemplate.getForEntity("http://HOTELAPP/hotel/gethotel/"+rating.getHotelId() , Hotel.class);
        		 //Hotel hotel = entity.getBody();
        		 
        		//call by feign client 
        		Hotel hotel = hotelService.getHotel(rating.getHotelId());
        	
        	
        		 //set the hotel to rating
        		 rating.setHotel(hotel);
        		 
        		//return the rating 
        		 return rating;
        	
        	}).collect(Collectors.toList());

        user.setRating(ratingList);

        return user;
        
    }
}
