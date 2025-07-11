package com.cognizant.spring_learn.service.impl;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryServiceImpl.class);

    private final ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

    @Override
    public Country getCountryIndia() {
        LOGGER.info("Fetching country with ID 'in' from XML");
        return context.getBean("in", Country.class);
    }

}
