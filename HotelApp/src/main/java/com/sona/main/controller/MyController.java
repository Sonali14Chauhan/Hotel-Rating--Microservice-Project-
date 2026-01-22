package com.sona.main.controller;

import com.sona.main.entity.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sona.main.dto.HotelDTO;
import com.sona.main.dto.updateHotelDTO;
import com.sona.main.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class MyController {

	@Autowired
	HotelService service;

    
	@PostMapping("/createhotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody HotelDTO hoteldto) {   //it automatically deserialize the  json/xml into java object 
		return service.saveHotel(hoteldto);	
	}
	
	@GetMapping("/gethotel")
	public List<Hotel> getAllHotels() {
		return service.getAllHotels();	
	}
	
	@GetMapping("/gethotel/{id}")
	public ResponseEntity<Hotel> getHotelByID(@PathVariable String id) {
		return service.getById(id);
		
	}
	
	@PutMapping("/updatehotel/{id}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable String id, @RequestBody updateHotelDTO hoteldto) {
		return service.update(id, hoteldto);
		
	}
	
	@DeleteMapping("/deletehotel/{id}")
	public void deleteHotel(@PathVariable String
			id) {
		  service.delete(id);
		
	}
	
	
	
}
