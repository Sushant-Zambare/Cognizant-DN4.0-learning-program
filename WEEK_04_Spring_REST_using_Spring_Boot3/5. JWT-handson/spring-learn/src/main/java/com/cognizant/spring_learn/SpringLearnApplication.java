package com.cognizant.spring_learn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringLearnApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		log.info("Application started successfully.");
	}
}
