package com.example.witchallengevaldompingacalculatorservice;

import com.example.witchallengevaldompingacalculatorservice.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class WitChallengeValdoMpingaApplicationTests {

    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
            "4, 1, 5.0000000000",                      // Simple addition
            "12345678901234567890, 98765432109876543210, 111111111011111111100.0000000000", // Large numbers
            "0.0000000001, 0.0000000002, 0.0000000003", // Small decimals
            "-1, 1, 0.0000000000"                       // Negative and positive numbers
    })
    void testAddition(String a, String b, String result) {
        assertEquals(new BigDecimal(result),
                calculatorService.add(new BigDecimal(a), new BigDecimal(b)));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 2.0000000000",                        // Positive numbers
            "12345678901234567890, 98765432109876543210, -86419753208641975320.0000000000", // Large numbers
            "0.0000000003, 0.0000000002, 0.0000000001",  // Small decimals
            "1, -1, 2.0000000000"                        // Positive and negative numbers
    })
    void testSubtraction(String a, String b, String result) {
        assertEquals(new BigDecimal(result),
                calculatorService.subtract(new BigDecimal(a), new BigDecimal(b)));
    }

    @ParameterizedTest
    @CsvSource({
            "123456789, 987654321, 121932631112635269.0000000000", // Large integers
            "0.0000000001, 0.0000000002, 0.0000000000",           // Small decimals
            "2, 3, 6.0000000000",                                // Normal multiplication
            "1.5, 2.5, 3.7500000000"                             // Decimal multiplication
    })
    void testMultiplication(String a, String b, String result) {
        assertEquals(new BigDecimal(result),
                calculatorService.multiply(new BigDecimal(a), new BigDecimal(b)));
    }

    @ParameterizedTest
    @CsvSource({
            //  "98765432109876543210, 123456789, 800000000000000000.0000000000", Large number division
            "1, 3, 0.3333333333",                                           // Non-terminating decimal
            "10, 3, 3.3333333333",                                          // Another non-terminating decimal
            "1, 1, 1.0000000000",                                           // Exact division
            "0.0000000004, 0.0000000002, 2.0000000000",                     // Small precision
            "0, 1, 0.0000000000"                                            // Zero numerator
    })
    void testDivision(String a, String b, String result) {
        assertEquals(new BigDecimal(result),
                calculatorService.divide(new BigDecimal(a), new BigDecimal(b)));
    }

    @ParameterizedTest
    @CsvSource({
            "6, 0",
            "-6, 0"
    })
    void testDivisionByZero(String a, String b) {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculatorService.divide(new BigDecimal(a), new BigDecimal(b));
        });
        assertEquals("Cannot divide by zero!!!", exception.getMessage());
    }

}
