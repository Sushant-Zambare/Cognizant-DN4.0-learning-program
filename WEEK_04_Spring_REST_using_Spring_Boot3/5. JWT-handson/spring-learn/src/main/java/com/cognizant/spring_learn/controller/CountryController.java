package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.exception.CountryNotFoundException;
import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Country Controller", description = "Perform CRUD Operations on Country")
@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    @Operation(summary = "Add a country.")
    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) {
        return countryService.addCountry(country);
    }

    @Operation(summary = "Get all the countries.")
    @GetMapping
    public List<Country> getAllCountries() {
        log.info("START getAllCountries()");
        List<Country> countries = countryService.getAllCountries();
        log.info("END getAllCountries()");
        return countries;
    }

    @Operation(summary = "Get a specific country by country code.")
    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) throws CountryNotFoundException {
        log.info("START getCountryByCode() with code: {}", code);
        Country country = countryService.getCountry(code);
        log.info("END getCountryByCode()");
        return country;
    }

    @Operation(summary = "Update a country.")
    @PutMapping("/{code}")
    public Country updateCountry(@PathVariable String code, @RequestBody Country country) {
        return countryService.updateCountry(code, country);
    }

    @Operation(summary = "Delete a country.")
    @DeleteMapping("/{code}")
    public void deleteCountry(@PathVariable String code) {
        countryService.deleteCountry(code);
    }
}
