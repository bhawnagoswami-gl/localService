package com.ac.documentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class DocumentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentManagementApplication.class, args);
	}

}
