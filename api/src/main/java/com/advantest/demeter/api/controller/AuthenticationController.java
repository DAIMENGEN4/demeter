package com.advantest.demeter.api.controller;

import com.advantest.demeter.api.vo.LoginResponseVO;
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

import java.util.NoSuchElementException;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseVO> login(@RequestBody LoginRequestDTO loginRequest, HttpServletResponse response) {
        try {
            LoginResponseDTO responseDTO = authenticationService.login(loginRequest);
            String refreshToken = responseDTO.refreshToken();
            Cookie refreshCookie = new Cookie("refresh_token", refreshToken);
            refreshCookie.setHttpOnly(true);
            refreshCookie.setPath("/api/v1/auth/refresh");
            refreshCookie.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(refreshCookie);
            return ResponseEntity.ok(LoginResponseVO.from(responseDTO));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(LoginResponseVO.defaultValue());
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(LoginResponseVO.defaultValue());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(LoginResponseVO.defaultValue());
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<String> refreshToken(HttpServletRequest request) {
        String refreshToken = authenticationService.refreshToken(request);
        return ResponseEntity.ok(refreshToken);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response) {
        Cookie refreshCookie = new Cookie("refresh_token", "");
        refreshCookie.setHttpOnly(true);
        refreshCookie.setPath("/api/v1/auth/refresh");
        refreshCookie.setMaxAge(0);
        response.addCookie(refreshCookie);
        return ResponseEntity.ok("Logout successful");
    }
}
