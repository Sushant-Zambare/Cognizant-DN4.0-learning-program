package com.cognizant.spring_learn.service.impl;

import com.cognizant.spring_learn.service.AuthenticationService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    private final SecretKey secretKey;

    public AuthenticationServiceImpl() {
        this.secretKey = Keys.hmacShaKeyFor("your-secret-key-must-be-at-least-32-characters-long-for-hs256".getBytes());
    }

    @Override
    public Map<String, String> authenticate(String authHeader) {
        log.info("authenticating...");
        log.debug("Authorization header: {}", authHeader);

        String user = getUser(authHeader);
        String token = generateJwt(user);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        log.info("authenticate method ended");
        return map;
    }

    private String getUser(String authHeader) {
        String encodedCredentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedCredentials = new String(decodedBytes);
        return decodedCredentials.substring(0, decodedCredentials.indexOf(':'));
    }

    private String generateJwt(String user) {
        String token = Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1200000))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();

        log.debug("JWT token generated for user: {}", user);
        return token;
    }
}