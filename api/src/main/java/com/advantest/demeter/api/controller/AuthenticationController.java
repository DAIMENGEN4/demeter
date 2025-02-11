package com.advantest.demeter.api.controller;

import com.advantest.demeter.authentication.details.EmployeeDetails;
import com.advantest.demeter.authentication.service.JwtService;
import com.advantest.demeter.service.dto.LoginFormDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@RestController
public class AuthenticationController {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationController(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginFormDTO loginForm) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
            return EmployeeDetails.parse(authentication.getPrincipal())
                    .map(employeeDetails -> ResponseEntity.ok(jwtService.generateToken(employeeDetails)))
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password"));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }
}
