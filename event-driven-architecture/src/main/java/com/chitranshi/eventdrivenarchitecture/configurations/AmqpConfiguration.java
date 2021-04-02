package com.chitranshi.eventdrivenarchitecture.configurations;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfiguration {

    private final String QUEUE_NAME="test_queue";

    @Bean
    public Queue getQueue() {
        return new Queue(QUEUE_NAME, true);
    }
}
