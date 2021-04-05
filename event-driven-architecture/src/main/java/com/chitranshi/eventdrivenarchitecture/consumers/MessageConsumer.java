package com.chitranshi.eventdrivenarchitecture.consumers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
@Slf4j
public class MessageConsumer {

    @RabbitListener(queues = "${broker.queue-name}")
    public void consumeMessage(Message message) throws UnsupportedEncodingException {
        log.info(String.format("The message recieved %s", new String(message.getBody(), "UTF-8")));
    }
}
