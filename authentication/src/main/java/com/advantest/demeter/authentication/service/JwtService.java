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
    private static final long ACCESS_EXPIRATION = 30 * 60 * 1000; // 30分钟内有效
    private static final long REFRESH_EXPIRATION = 7 * 24 * 60 * 60 * 1000; // 7天有效

    private String generateToken(EmployeeDetails details, long expiration) {
        var authorities = details.getAuthorities()
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
                .withExpiresAt(new Date(System.currentTimeMillis() + expiration))
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    public String generateAccessToken(EmployeeDetails details) {
        return generateToken(details, ACCESS_EXPIRATION);
    }

    public String generateRefreshToken(EmployeeDetails details) {
        return generateToken(details, REFRESH_EXPIRATION);
    }

    public EmployeeDetails verifyToken(String token) {
        var decodedJWT = JWT.require(Algorithm.HMAC256(SECRET_KEY))
                .withIssuer("demeter")
                .withAudience("https://demeter.advantest.com")
                .build()
                .verify(token);
        var username = decodedJWT.getSubject();
        var password = decodedJWT.getClaim("password").asString();
        var employeeId = decodedJWT.getClaim("employeeId").asLong();
        var employeeName = decodedJWT.getClaim("employeeName").asString();
        var authorities = decodedJWT.getClaim("authorities").asArray(String.class);
        var list = Arrays.stream(authorities).map(SimpleGrantedAuthority::new).toList();
        return new EmployeeDetails(employeeId, username, password, employeeName, list);
    }
}
