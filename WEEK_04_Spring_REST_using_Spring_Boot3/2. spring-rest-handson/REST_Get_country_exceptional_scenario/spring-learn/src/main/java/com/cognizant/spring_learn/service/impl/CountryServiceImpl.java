package com.cognizant.spring_learn.service.impl;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryServiceImpl.class);

    private final ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

    @Override
    public Country getCountryIndia() {
        LOGGER.info("Fetching country with ID 'in' from XML");
        return context.getBean("in", Country.class);
    }

    @Override
    public List<Country> getAllCountries() {
        LOGGER.info("Fetching all countries from XML");
        return context.getBean("countryList", List.class);
    }

    @Override
    public Country getCountry(String code) {
        LOGGER.info("Searching country by code : {}", code);
        List<Country> countryList = getAllCountries();
        return countryList.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException(code));
    }
}
