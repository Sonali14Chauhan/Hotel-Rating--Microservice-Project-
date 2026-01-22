package com.example.Hotel_Eureka_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HotelEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelEurekaServiceApplication.class, args);
	}

}
