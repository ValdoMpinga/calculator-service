package com.example.witchallengevaldompingacalculatorservice.controller;


import com.example.witchallengevaldompingacalculatorservice.dto.CalculatorDTO;
import com.example.witchallengevaldompingacalculatorservice.service.CalculatorService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
@RequestMapping("/calculator")
public class CalculatorServiceController {

    private final RabbitTemplate rabbitTemplate;
    private final String queueName;

    public CalculatorServiceController(RabbitTemplate rabbitTemplate,
                                @Value("${rabbitmq.queue.name}") String queueName) {
        this.rabbitTemplate = rabbitTemplate;
        this.queueName = queueName;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendRequest(@RequestBody CalculatorDTO request) {
        rabbitTemplate.convertAndSend(queueName, request);
        return ResponseEntity.ok("Request sent to RabbitMQ");
    }
}
