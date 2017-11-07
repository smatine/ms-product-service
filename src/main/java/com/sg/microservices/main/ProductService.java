package com.sg.microservices.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@Component
@ComponentScan("com.sg.microservices.product")
@CrossOrigin
public class ProductService {
	
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate(){
	return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProductService.class, args);
	}
	

}