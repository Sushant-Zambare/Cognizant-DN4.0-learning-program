package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDao {

    private final ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

    public List<Country> getAllCountries() {
        return context.getBean("countryList", List.class);
    }

    public Country getCountryByCode(String code) {
        return getAllCountries().stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}

