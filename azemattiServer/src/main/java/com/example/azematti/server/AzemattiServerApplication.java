package com.example.azematti.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AzemattiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzemattiServerApplication.class, args);
	}

}
