package com.cognizant.orm_learn;

import com.cognizant.orm_learn.exception.CountryNotFoundException;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	public static void main(String[] args) throws CountryNotFoundException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);

		getCountryTest();
		testAddCountry();
		testUpdateCountry();
		testDeleteCountry();
	}

	private static void getCountryTest() throws CountryNotFoundException {
		LOGGER.info("Start getCountryTest");
		Country country = countryService.findCountryByCode("IN");
		LOGGER.debug("Country: {}", country);
		LOGGER.info("End getCountryTest");
	}

	private static void testAddCountry() throws CountryNotFoundException {
		LOGGER.info("Start testAddCountry");
		Country country = new Country();
		country.setCode("ZZ");
		country.setName("Zootopia");
		countryService.addCountry(country);

		Country addedCountry = countryService.findCountryByCode("ZZ");
		LOGGER.debug("Added Country: {}", addedCountry);
		LOGGER.info("End testAddCountry");
	}

	private static void testUpdateCountry() throws CountryNotFoundException {
		LOGGER.info("Start testUpdateCountry");
		countryService.updateCountry("ZZ", "Zebraland");
		Country updatedCountry = countryService.findCountryByCode("ZZ");
		LOGGER.debug("Updated Country: {}", updatedCountry);
		LOGGER.info("End testUpdateCountry");
	}

	private static void testDeleteCountry() {
		LOGGER.info("Start testDeleteCountry");
		countryService.deleteCountry("ZZ");
		LOGGER.info("End testDeleteCountry");
	}
}



