package com.sel.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApiAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAccountApplication.class, args);
	}
}
