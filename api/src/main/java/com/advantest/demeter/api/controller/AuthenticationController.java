package com.advantest.demeter.api.controller;

import com.advantest.demeter.authentication.dto.LoginRequestDTO;
import com.advantest.demeter.authentication.dto.LoginResponseDTO;
import com.advantest.demeter.authentication.service.AuthenticationService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private static final String COOKIE_PATH = "/api/v1/auth/refresh";
    private static final String REFRESH_TOKEN_COOKIE_NAME = "refresh_token";

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest, HttpServletResponse response) {
        try {
            LoginResponseDTO responseDTO = authenticationService.login(loginRequest);
            String refreshToken = responseDTO.refreshToken();
            Cookie refreshCookie = new Cookie(REFRESH_TOKEN_COOKIE_NAME, refreshToken);
            refreshCookie.setHttpOnly(true);
            refreshCookie.setPath(COOKIE_PATH);
            refreshCookie.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(refreshCookie);
            return ResponseEntity.ok(responseDTO);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(LoginResponseDTO.defaultValue());
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(LoginResponseDTO.defaultValue());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(LoginResponseDTO.defaultValue());
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<String> refreshToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No refresh token");
        }
        String refreshToken = Arrays.stream(cookies)
                .filter(c -> REFRESH_TOKEN_COOKIE_NAME.equals(c.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(null);
        if (refreshToken == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No refresh token");
        }
        try {
            String accessToken = authenticationService.refreshToken(refreshToken);
            return ResponseEntity.ok(accessToken);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response) {
        Cookie refreshCookie = new Cookie(REFRESH_TOKEN_COOKIE_NAME, "");
        refreshCookie.setHttpOnly(true);
        refreshCookie.setPath(COOKIE_PATH);
        refreshCookie.setMaxAge(0);
        response.addCookie(refreshCookie);
        return ResponseEntity.ok("Logout successful");
    }
}
