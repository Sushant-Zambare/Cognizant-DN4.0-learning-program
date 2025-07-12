package com.cognizant.spring_learn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country not found")
public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(String code) {
        super("Country not found with code: " + code);
    }
}
