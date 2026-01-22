package com.example.demo.entity;

import lombok.Data;

@Data
public class Hotel {
	 	private String id;
	    private String name;
	    private String address;
	    private String city;
	    private double rating;
	    private boolean isAvailable;
}
