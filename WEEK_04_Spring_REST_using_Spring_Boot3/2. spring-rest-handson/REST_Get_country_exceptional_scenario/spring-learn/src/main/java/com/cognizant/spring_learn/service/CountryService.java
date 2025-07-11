package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.model.Country;

import java.util.List;

public interface CountryService {
    Country getCountryIndia();
    List<Country> getAllCountries();
    Country getCountry(String code);
}
