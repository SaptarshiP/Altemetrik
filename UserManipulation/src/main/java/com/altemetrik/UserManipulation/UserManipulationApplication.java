package com.altemetrik.UserManipulation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableDiscoveryClient
public class UserManipulationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManipulationApplication.class, args);
	}

}
