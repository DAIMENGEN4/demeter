package com.advantest.demeter.authentication.details;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetails implements UserDetails {
    private Long employeeId;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
}
