package com.advantest.demeter.api.controller;

import com.advantest.demeter.api.dto.HelloWorldDto;
import com.advantest.demeter.database.entity.EmployeeEntity;
import com.advantest.demeter.database.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@RestController
public class HelloWorldController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/hello")
    public HelloWorldDto hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        EmployeeEntity employee = employeeService.getById(1);
        System.out.println(employee);
        return new HelloWorldDto(counter.incrementAndGet(), String.format(template, name));
    }
}
