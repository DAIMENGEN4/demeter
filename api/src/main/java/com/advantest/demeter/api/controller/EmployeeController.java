package com.advantest.demeter.api.controller;

import com.advantest.demeter.service.EmployeeService;
import com.advantest.demeter.service.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/register")
    public ResponseEntity<Boolean> registerEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Boolean result = employeeService.registerEmployee(employeeDTO);
        return ResponseEntity.ok(result);
    }
}
