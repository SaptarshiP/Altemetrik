package com.altemetrik.AltemetrikOrderManipulation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AltemetrikOrderManipulationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AltemetrikOrderManipulationApplication.class, args);
	}

}
