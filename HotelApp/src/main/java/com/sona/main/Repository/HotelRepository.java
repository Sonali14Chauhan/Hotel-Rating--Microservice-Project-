package com.sona.main.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sona.main.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {
	
	Optional<Hotel> findByName(String name);
	
	
}
