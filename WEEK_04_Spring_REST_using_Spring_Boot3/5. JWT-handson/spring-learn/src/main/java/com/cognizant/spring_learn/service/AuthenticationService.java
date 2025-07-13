package com.cognizant.spring_learn.service;

import java.util.Map;

public interface AuthenticationService {
    Map<String, String> authenticate(String authHeader);
}
