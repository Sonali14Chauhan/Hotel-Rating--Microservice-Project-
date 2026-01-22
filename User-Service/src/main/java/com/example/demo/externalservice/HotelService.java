package com.example.demo.externalservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Hotel;

@FeignClient(name = "HOTELAPP")
public interface HotelService {
	
	@GetMapping("/hotel/gethotel/{hotelId}")
	Hotel getHotel(@PathVariable String hotelId);

}
