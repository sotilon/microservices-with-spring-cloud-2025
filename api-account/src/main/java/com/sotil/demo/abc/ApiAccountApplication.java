package com.sotil.demo.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableCaching  // Enables caching in Spring Boot
@EnableDiscoveryClient
@SpringBootApplication
public class ApiAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAccountApplication.class, args);
	}
}
