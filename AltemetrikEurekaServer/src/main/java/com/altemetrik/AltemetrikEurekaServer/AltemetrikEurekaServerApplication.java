package com.altemetrik.AltemetrikEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AltemetrikEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AltemetrikEurekaServerApplication.class, args);
	}

}
