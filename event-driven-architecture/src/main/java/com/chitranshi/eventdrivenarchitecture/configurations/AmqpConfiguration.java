package com.chitranshi.eventdrivenarchitecture.configurations;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfiguration {

    @Value("${broker.queue-name}")
    private String QUEUE_NAME;

    @Bean
    public Queue getQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public FanoutExchange getExchange() {
        return new FanoutExchange("message-fanout");
    }

    @Bean
    public Binding getBinding() {
        return BindingBuilder.bind(getQueue()).to(getExchange());
    }
}
