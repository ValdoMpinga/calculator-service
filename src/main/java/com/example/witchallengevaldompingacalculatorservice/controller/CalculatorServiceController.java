package com.example.witchallengevaldompingacalculatorservice.controller;


import com.example.witchallengevaldompingacalculatorservice.dto.CalculatorDTO;
import com.example.witchallengevaldompingacalculatorservice.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
@RequestMapping("/calculator")
public class CalculatorServiceController {

    private final CalculatorService calculatorService;

    public CalculatorServiceController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/add")
    public ResponseEntity<BigDecimal> add(@RequestBody CalculatorDTO request) {
        System.out.println("Adding");
        return ResponseEntity.ok(calculatorService.add(request.getA(), request.getB()));
    }

    @PostMapping("/subtract")
    public ResponseEntity<BigDecimal> subtract(@RequestBody CalculatorDTO request) {
        System.out.println("Subtracting");
        return ResponseEntity.ok(calculatorService.subtract(request.getA(), request.getB()));
    }

    @PostMapping("/multiply")
    public ResponseEntity<BigDecimal> multiply(@RequestBody CalculatorDTO request) {
        System.out.println("Multiplication");
        return ResponseEntity.ok(calculatorService.multiply(request.getA(), request.getB()));
    }

    @PostMapping("/divide")
    public ResponseEntity<BigDecimal> divide(@RequestBody CalculatorDTO request) {
        System.out.println("Dividing");

        try {
            return ResponseEntity.ok(calculatorService.divide(request.getA(), request.getB()));
        } catch (ArithmeticException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
