package com.altemetrik.AltemetrikOrderManipulation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;

@Configuration
@PropertySource("classpath:CUSTOM_MESSAGE.properties")
public class AppConfig {

	@Bean("RestTemplate")
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
