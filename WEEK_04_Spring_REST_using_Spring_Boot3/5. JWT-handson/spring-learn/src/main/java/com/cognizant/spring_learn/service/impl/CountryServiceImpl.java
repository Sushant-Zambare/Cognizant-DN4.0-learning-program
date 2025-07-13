package com.cognizant.spring_learn.service.impl;

import com.cognizant.spring_learn.dao.CountryDao;
import com.cognizant.spring_learn.exception.CountryNotFoundException;
import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private CountryDao countryDao;

    private final List<Country> additionalCountries = new ArrayList<>();

    @Override
    public Country getCountry(String code) {
        Country country = countryDao.getCountryByCode(code);
        if (country == null) {
            country = additionalCountries.stream()
                    .filter(c -> c.getCode().equalsIgnoreCase(code))
                    .findFirst()
                    .orElseThrow(() -> new CountryNotFoundException(code));
        }
        return country;
    }

    @Override
    public List<Country> getAllCountries() {
        List<Country> countries = new ArrayList<>(countryDao.getAllCountries());
        countries.addAll(additionalCountries);
        return countries;
    }

    @Override
    public Country addCountry(Country country) {
        if (getAllCountries().stream()
                .anyMatch(c -> c.getCode().equalsIgnoreCase(country.getCode()))) {
            throw new RuntimeException("Country already exists");
        }
        additionalCountries.add(country);
        return country;
    }

    @Override
    public Country updateCountry(String code, Country updatedCountry) {
        Country existing = getCountry(code);
        existing.setName(updatedCountry.getName());
        return existing;
    }

    @Override
    public void deleteCountry(String code) {
        boolean removed = additionalCountries.removeIf(c -> c.getCode().equalsIgnoreCase(code));
        if (!removed) {
            throw new CountryNotFoundException(code);
        }
    }
}
