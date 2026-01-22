package com.sona.main.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="user_rating")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "rating_id")
    private String ratingId;   // use lowercase "id" for consistency
    private String userId;
    private String hotelId;
    private Float actualHotelRating;
    private String reviews;
    
    

    
}
