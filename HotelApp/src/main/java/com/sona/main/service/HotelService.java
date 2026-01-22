package com.sona.main.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sona.main.Repository.HotelRepository;
import com.sona.main.communicator.RestTemplateCommunicator;
import com.sona.main.dto.HotelDTO;
import com.sona.main.dto.updateHotelDTO;
import com.sona.main.entity.Hotel;
import com.sona.main.exception.DuplicateHotelFoundEx;
import com.sona.main.exception.HotelNotFoundEx;


@Service
public class HotelService {

	  @Autowired
      HotelRepository repository;
	  
	  
	  @Autowired
	  RestTemplateCommunicator restTemplateCommunicator;

    public ResponseEntity<Hotel> saveHotel(HotelDTO dto) {
        if (repository.findByName(dto.getName()).isPresent()) {
            throw new DuplicateHotelFoundEx("Hotel with name '" + dto.getName() + "' already exists");
        }

        Hotel hotel = new Hotel();
        hotel.setId(UUID.randomUUID().toString());
        hotel.setName(dto.getName());
        hotel.setAddress(dto.getAddress());
        hotel.setCity(dto.getCity());
        hotel.setRating(dto.getRating());
        hotel.setAvailable(dto.isAvailable());

        Hotel savedHotel = repository.save(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
    }

    public List<Hotel> getAllHotels() {
        return repository.findAll();
    }

    public ResponseEntity<Hotel> getById(String id) {
        Hotel hotel = repository.findById(id)
                .orElseThrow(() -> new HotelNotFoundEx("Hotel with Id " + id + " not found"));
      
//        Float hotelActalRating = restTemplateCommunicator.getActualHotelRating(id);
//        hotel.setRating(hotelActalRating);
        
        return ResponseEntity.ok(hotel);
    }

    public ResponseEntity<Hotel> update(String id, updateHotelDTO dto) {
        Hotel hotel = repository.findById(id)
                .orElseThrow(() -> new HotelNotFoundEx("Hotel with Id " + id + " not found"));

        hotel.setAddress(dto.getAddress());
        hotel.setCity(dto.getCity());
        Hotel updatedHotel = repository.save(hotel);
        return ResponseEntity.ok(updatedHotel);
    }

    public void delete(String id) {
        Hotel hotel = repository.findById(id)
                .orElseThrow(() -> new HotelNotFoundEx("Hotel with Id " + id + " not found"));

		 repository.delete(hotel);
    }
}
