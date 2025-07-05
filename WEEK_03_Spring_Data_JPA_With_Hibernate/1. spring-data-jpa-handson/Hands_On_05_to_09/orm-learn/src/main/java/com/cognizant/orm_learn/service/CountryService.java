package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.exception.CountryNotFoundException;
import com.cognizant.orm_learn.model.Country;

public interface CountryService {
    Country findCountryByCode(String code) throws CountryNotFoundException;
    void addCountry(Country country);
    void updateCountry(String code, String name) throws CountryNotFoundException;
    void deleteCountry(String code);
}
