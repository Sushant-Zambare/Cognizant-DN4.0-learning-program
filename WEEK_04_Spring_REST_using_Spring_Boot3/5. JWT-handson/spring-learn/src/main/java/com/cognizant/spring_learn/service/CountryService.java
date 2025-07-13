package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.model.Country;

import java.util.List;

public interface CountryService {
    Country addCountry(Country country);
    List<Country> getAllCountries();
    Country getCountry(String code);
    Country updateCountry(String code, Country country);
    void deleteCountry(String code);
}
