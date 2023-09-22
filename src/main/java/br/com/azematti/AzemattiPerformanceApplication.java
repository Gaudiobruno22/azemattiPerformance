package br.com.azematti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AzemattiPerformanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzemattiPerformanceApplication.class, args);
	}
}
