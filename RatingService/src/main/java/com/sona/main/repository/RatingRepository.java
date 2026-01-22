package com.sona.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sona.main.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {
    // Find all ratings for a hotel
	List<Rating> findByHotelId(String hotelId);
    
    List<Rating> findByUserId(String userId);
}
