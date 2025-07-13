package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.service.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Tag(name = "Authentication Controller", description = "Handles Authentication for users")
@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/authenticate")
public class AuthenticationController {

    private final AuthenticationService authService;

    @GetMapping()
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        return authService.authenticate(authHeader);
    }
}
