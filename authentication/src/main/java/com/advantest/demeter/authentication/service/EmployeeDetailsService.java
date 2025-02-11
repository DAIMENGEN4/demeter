package com.advantest.demeter.authentication.service;

import com.advantest.demeter.authentication.details.EmployeeDetails;
import com.advantest.demeter.service.EmployeeService;
import com.advantest.demeter.service.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class EmployeeDetailsService implements UserDetailsService {

    private final EmployeeService employeeService;

    @Override
    public EmployeeDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EmployeeDTO employee = employeeService.getEmployeeByAccount(username);
        if (employee == null) {
            throw new UsernameNotFoundException("User not found");
        }
        Long employeeId = employee.getId();
        String password = new BCryptPasswordEncoder().encode(employee.getPassword());
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("admin"));
        return new EmployeeDetails(employeeId, username, password, authorities);
    }
}
