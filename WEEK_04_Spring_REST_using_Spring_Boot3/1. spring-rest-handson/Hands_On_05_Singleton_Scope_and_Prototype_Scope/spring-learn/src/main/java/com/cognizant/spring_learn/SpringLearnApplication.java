package com.cognizant.spring_learn;

import com.cognizant.spring_learn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("Application started successfully.");
		displayCountry();
	}

	public static void displayCountry() {
		LOGGER.info("START COUNTRY");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country1 = context.getBean("country", Country.class);
		Country country2 = context.getBean("country", Country.class);
		LOGGER.debug("Country 1: {}", country1);
		LOGGER.debug("Country 2: {}", country2);
		LOGGER.debug("Are both instances the same? {}", country1 == country2);
		LOGGER.info("END COUNTRY");
	}

}
