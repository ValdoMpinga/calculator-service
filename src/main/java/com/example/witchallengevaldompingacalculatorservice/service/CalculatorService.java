package com.example.witchallengevaldompingacalculatorservice.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculatorService {
    private static final int SCALE = 10;

    public BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b).setScale(SCALE, RoundingMode.HALF_UP);
    }

    public BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b).setScale(SCALE, RoundingMode.HALF_UP);
    }

    public BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b).setScale(SCALE, RoundingMode.HALF_UP);
    }

    public BigDecimal divide(BigDecimal a, BigDecimal b) {
        if (b.compareTo(BigDecimal.ZERO) == 0) {
            throw new ArithmeticException("Cannot divide by zero!!!");
        }
        return a.divide(b, SCALE, RoundingMode.HALF_UP);
    }
}