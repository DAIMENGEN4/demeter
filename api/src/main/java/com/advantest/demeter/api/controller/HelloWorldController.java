package com.advantest.demeter.api.controller;

import com.advantest.demeter.api.vo.HelloWorldVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@RestController
@RequestMapping("/api")
public class HelloWorldController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello")
    public ResponseEntity<HelloWorldVO> hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return ResponseEntity.ok(new HelloWorldVO(counter.incrementAndGet(), String.format(template, name)));
    }
}
