package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
	
	private String ratingId;
	private String userId;
	private String hotelId;
	private Float actualHotelRating;
    private String reviews;
    private Hotel hotel;
}
