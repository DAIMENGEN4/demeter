package com.advantest.demeter.authentication.filter;

import com.advantest.demeter.authentication.service.JwtService;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;

    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        try {
            var optionalToken = getJwtFromRequest(request);
            if (optionalToken.isPresent()) {
                var employeeDetails = jwtService.verifyToken(optionalToken.get());
                if (employeeDetails == null) {
                    throw new SecurityException("Invalid token: user not found");
                }
                var authentication = new UsernamePasswordAuthenticationToken(employeeDetails, null, employeeDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);
        } catch (SecurityException | TokenExpiredException e) {
            handleException(request, response, e.getMessage(), HttpServletResponse.SC_UNAUTHORIZED);
        } catch (Exception e) {
            handleException(request, response, e.getMessage(), HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    private Optional<String> getJwtFromRequest(HttpServletRequest request) {
        var bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return Optional.of(bearerToken.substring(7));
        }
        return Optional.empty();
    }

    private void handleException(HttpServletRequest request, HttpServletResponse response, String message, int statusCode) throws IOException {
        response.setStatus(statusCode);
        response.setContentType("application/json;charset=UTF-8");
        // 移除 WWW-Authenticate 头，避免浏览器弹出认证框
        response.setHeader("WWW-Authenticate", "");
        var errorResponse = new HashMap<String, Object>();
        errorResponse.put("status", statusCode);
        errorResponse.put("error", statusCode == 401 ? "Unauthorized" : "Internal Server Error");
        errorResponse.put("message", message);
        errorResponse.put("path", request.getRequestURI());
        errorResponse.put("timestamp", System.currentTimeMillis());
        response.getWriter().write(new ObjectMapper().writeValueAsString(errorResponse));
    }
}
