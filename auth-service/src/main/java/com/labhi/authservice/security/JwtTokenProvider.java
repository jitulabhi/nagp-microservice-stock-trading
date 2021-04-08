package com.labhi.authservice.security;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labhi.auth.model.JwtToken;
import com.labhi.authservice.dao.JwtTokenRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
    private static final String AUTH="auth";
    private String secretKey="secret-key";
    private long validityInMilliseconds = 3600000; // 1h

    @Autowired
    private JwtTokenRepository jwtTokenRepository;


    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String username, List<String> roles) {

        Claims claims = Jwts.claims().setSubject(username);
        claims.put(AUTH,roles);

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        String token =  Jwts.builder()//
                .setClaims(claims)//
                .setIssuedAt(now)//
                .setExpiration(validity)//
                .signWith(SignatureAlgorithm.HS256, secretKey)//
                .compact();
        jwtTokenRepository.save(new JwtToken(token));
        return token;
    }

    
    public boolean isTokenPresentInDB (String token) {
        return jwtTokenRepository.findById(token).isPresent();
    }
   
  

}
