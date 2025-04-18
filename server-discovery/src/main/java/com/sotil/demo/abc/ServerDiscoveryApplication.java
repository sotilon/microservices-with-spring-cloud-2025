package com.sotil.demo.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServerDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerDiscoveryApplication.class, args);
	}

}
