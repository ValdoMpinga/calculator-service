package com.example.witchallengevaldompingacalculatorservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class CalculatorDTO {

    @JsonProperty("a")
    private BigDecimal a;

    @JsonProperty("b")
    private BigDecimal b;

    @JsonProperty("operation")
    private String operation;

}