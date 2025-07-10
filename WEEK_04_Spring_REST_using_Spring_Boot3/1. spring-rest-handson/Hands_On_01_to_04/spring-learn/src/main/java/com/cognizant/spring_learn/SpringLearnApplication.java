package com.cognizant.spring_learn;

import com.cognizant.spring_learn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("Application started successfully.");
		displayDate();
		displayCountry();
	}

//	Hands_On_02, 03
	public static void displayDate() {
		LOGGER.info("START OF DISPLAY DATE");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date parsedDate = format.parse("31/12/2018");
			LOGGER.debug("Date: {}", parsedDate);
		} catch (Exception e) {
			LOGGER.error("Error for parsing date", e);
		}
		LOGGER.info("END OF DISPLAY DATE");
	}

//	Hands_On_04
	public static void displayCountry() {
		LOGGER.info("START COUNTRY");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country);
		LOGGER.info("END COUNTRY");
	}
}
