package com.cognizant.account.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/accounts")
public class Account {
    @GetMapping("/{number}")
    public Map<String, Object> getAccount(@PathVariable int number) {
        return Map.of(
                "number", number,
                "type", "savings",
                "balance", 234343
        );
    }
}
