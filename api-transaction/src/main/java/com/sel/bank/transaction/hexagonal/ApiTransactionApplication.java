package com.sel.bank.transaction.hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApiTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTransactionApplication.class, args);
	}
}
