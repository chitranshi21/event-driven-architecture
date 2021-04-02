package com.chitranshi.eventdrivenarchitecture.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/run")
public class HomeController {

    private final String QUEUE_NAME="test_queue";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/{message}")
    public String sendMessage(@PathVariable("message") String message) {
        rabbitTemplate.convertAndSend(QUEUE_NAME, message);
        return "Message sent";
    }
}
