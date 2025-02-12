package com.advantest.demeter.authentication.service;

import com.advantest.demeter.authentication.details.EmployeeDetails;
import com.advantest.demeter.authentication.dto.LoginRequestDTO;
import com.advantest.demeter.authentication.dto.LoginResponseDTO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Create on 2025/02/11
 * Author: mengen.dai@advantest.com
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
        Optional<EmployeeDetails> optional = EmployeeDetails.parse(authentication.getPrincipal());
        if (optional.isPresent()) {
            EmployeeDetails employeeDetails = optional.get();
            String accessToken = jwtService.generateAccessToken(employeeDetails);
            String refreshToken = jwtService.generateRefreshToken(employeeDetails);
            return new LoginResponseDTO(accessToken, refreshToken, employeeDetails.getEmployeeId(), employeeDetails.getEmployeeName());
        }
        throw new NoSuchElementException("Failed to parse employee details");
    }

    public String refreshToken(HttpServletRequest request) throws NoSuchElementException {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            throw new NoSuchElementException("No refresh token");
        }
        String refreshToken = Arrays.stream(cookies)
                .filter(c -> "refresh_token".equals(c.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(null);
        if (refreshToken == null) {
            throw new NoSuchElementException("No refresh token");
        }
        try {
            EmployeeDetails employeeDetails = jwtService.verifyToken(refreshToken);
            return jwtService.generateAccessToken(employeeDetails);
        } catch (Exception e) {
            throw new NoSuchElementException("Invalid refresh token");
        }
    }
}
