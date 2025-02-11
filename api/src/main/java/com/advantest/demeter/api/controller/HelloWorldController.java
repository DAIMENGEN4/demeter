package com.advantest.demeter.api.controller;

import com.advantest.demeter.api.vo.HelloWorldVO;
import com.advantest.demeter.database.po.EmployeePO;
import com.advantest.demeter.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<HelloWorldVO> hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        EmployeePO employee = employeeService.getById(1);
        System.out.println(employee);
        return ResponseEntity.ok(new HelloWorldVO(counter.incrementAndGet(), String.format(template, name)));
    }
}
