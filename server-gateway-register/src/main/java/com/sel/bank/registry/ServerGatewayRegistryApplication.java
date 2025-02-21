package com.sel.bank.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServerGatewayRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerGatewayRegistryApplication.class, args);
	}

}
