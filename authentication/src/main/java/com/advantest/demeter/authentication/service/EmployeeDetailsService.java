package com.advantest.demeter.authentication.service;

import com.advantest.demeter.authentication.details.EmployeeDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Service
public class EmployeeDetailsService implements UserDetailsService {

    @Override
    public EmployeeDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("admin")) {
            Long employeeId = 1L;
            String password = new BCryptPasswordEncoder().encode("123456");
            List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("admin"));
            return new EmployeeDetails(employeeId, username, password, authorities);
        }
        throw new UsernameNotFoundException("User not found");
    }
}
