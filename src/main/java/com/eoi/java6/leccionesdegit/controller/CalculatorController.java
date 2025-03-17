package com.eoi.java6.leccionesdegit.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @GetMapping("/sumar")
    public int sumar(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }
}
