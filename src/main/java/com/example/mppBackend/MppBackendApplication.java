package com.example.mppBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.mppBackend.repository")
public class MppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MppBackendApplication.class, args);
	}
}