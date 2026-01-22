package com.sona.main.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    private String id;

    private String name;
    private String address;
    private String city;
    private double rating;

    @Column(name = "available")
    private boolean isAvailable;

    
	
    
    
}
