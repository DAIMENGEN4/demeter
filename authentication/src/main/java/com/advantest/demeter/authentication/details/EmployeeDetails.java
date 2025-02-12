package com.advantest.demeter.authentication.details;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Optional;

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
    private String employeeName;
    private Collection<? extends GrantedAuthority> authorities;

    public static Optional<EmployeeDetails> parse(Object object) {
        if (object instanceof EmployeeDetails) {
            return Optional.of((EmployeeDetails) object);
        } else {
            return Optional.empty();
        }
    }
}
