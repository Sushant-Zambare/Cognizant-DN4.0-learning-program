package com.cognizant.orm_learn.controller;

import com.cognizant.orm_learn.exception.CountryNotFoundException;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/{code}")
    public ResponseEntity<Country> getCountryByCode(@PathVariable String code) throws CountryNotFoundException {
        Country country = countryService.findCountryByCode(code);
        return ResponseEntity.ok(country);
    }

    @PostMapping
    public ResponseEntity<String> addCountry(@RequestBody Country country) {
        countryService.addCountry(country);
        return ResponseEntity.status(HttpStatus.CREATED).body("Country added successfully");
    }

    @PutMapping("/{code}")
    public ResponseEntity<String> updateCountry(@PathVariable String code, @RequestBody Country countryDetails) throws CountryNotFoundException {
        countryService.updateCountry(code, countryDetails.getName());
        return ResponseEntity.ok("Country updated successfully");
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteCountry(@PathVariable String code) {
        countryService.deleteCountry(code);
        return ResponseEntity.ok("Country deleted successfully");
    }

}

