package com.example.witchallengevaldompingacalculatorservice.dto;

import java.math.BigDecimal;

public class CalculatorDTO {
    private BigDecimal a;
    private BigDecimal b;


    public BigDecimal getA() {
        return a;
    }

    public void setA(BigDecimal a) {
        this.a = a;
    }

    public BigDecimal getB() {
        return b;
    }

    public void setB(BigDecimal b) {
        this.b = b;
    }
}
