package com.advantest.demeter.authentication.service;

import com.advantest.demeter.authentication.details.EmployeeDetails;
import com.advantest.demeter.service.dto.LoginFormDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

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

    public String login(LoginFormDTO loginForm) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
        Optional<EmployeeDetails> optional = EmployeeDetails.parse(authentication.getPrincipal());
        if (optional.isPresent()) {
            EmployeeDetails employeeDetails = optional.get();
            return jwtService.generateToken(employeeDetails);
        }
        throw new NoSuchElementException("Failed to parse employee details");
    }
}
