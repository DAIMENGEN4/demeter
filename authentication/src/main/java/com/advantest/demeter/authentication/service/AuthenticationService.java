package com.advantest.demeter.authentication.service;

import com.advantest.demeter.authentication.details.EmployeeDetails;
import com.advantest.demeter.authentication.dto.LoginRequestDTO;
import com.advantest.demeter.authentication.dto.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
        var optional = EmployeeDetails.parse(authentication.getPrincipal());
        if (optional.isPresent()) {
            var employeeDetails = optional.get();
            var accessToken = jwtService.generateAccessToken(employeeDetails);
            var refreshToken = jwtService.generateRefreshToken(employeeDetails);
            return new LoginResponseDTO(accessToken, refreshToken, employeeDetails.getEmployeeId(), employeeDetails.getEmployeeName());
        }
        throw new NoSuchElementException("Failed to parse employee details");
    }

    public String refreshToken(String refreshToken) {
        var employeeDetails = jwtService.verifyToken(refreshToken);
        return jwtService.generateAccessToken(employeeDetails);
    }
}
