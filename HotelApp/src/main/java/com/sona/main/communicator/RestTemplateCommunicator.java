package com.sona.main.communicator;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateCommunicator {

	private final RestTemplate restTemplate;
	
	public RestTemplateCommunicator(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	
	public Float getActualHotelRating(String id){
		
		String url = "http://localhost:9096/rating/getratingbyhotelid/"+id;
		ResponseEntity<Float> hotelRating = restTemplate.getForEntity(url, Float.class);
		return hotelRating.getBody();
		
	}
	
}
