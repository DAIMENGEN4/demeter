package com.advantest.demeter.authentication.service;

import com.advantest.demeter.authentication.details.EmployeeDetails;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Component
public class JwtService {
    private static final String SECRET_KEY = "secret";
    private static final int EXPIRATION_TIME = 24 * 60 * 60 * 1000;

    public String generateToken(EmployeeDetails details) {
        String[] authorities = details.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toArray(String[]::new);
        return JWT.create()
                .withJWTId(details.getUsername())
                .withIssuer("demeter")
                .withIssuedAt(new Date())
                .withAudience("https://demeter.advantest.com")
                .withSubject(details.getUsername())
                .withClaim("password", details.getPassword())
                .withClaim("employeeId", details.getEmployeeId())
                .withClaim("employeeName", details.getEmployeeName())
                .withArrayClaim("authorities", authorities)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    public EmployeeDetails verifyToken(String token) {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET_KEY))
                .withIssuer("demeter")
                .withAudience("https://demeter.advantest.com")
                .build()
                .verify(token);
        String username = decodedJWT.getSubject();
        String password = decodedJWT.getClaim("password").asString();
        String employeeId = decodedJWT.getClaim("employeeId").asString();
        String employeeName = decodedJWT.getClaim("employeeName").asString();
        String[] authorities = decodedJWT.getClaim("authorities").asArray(String.class);
        List<SimpleGrantedAuthority> list = Arrays.stream(authorities).map(SimpleGrantedAuthority::new).toList();
        return new EmployeeDetails(Long.parseLong(employeeId), username, password, employeeName, list);
    }
}
