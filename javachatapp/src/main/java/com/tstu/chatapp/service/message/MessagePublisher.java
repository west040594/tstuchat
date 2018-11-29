package com.tstu.chatapp.service.message;

import com.tstu.chatapp.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessagePublisher {
    private final AmqpTemplate amqpTemplate;

    @Value("${spring.rabbitmq.template.exchange}")
    public String exchange;

    @Autowired
    public MessagePublisher(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void publish(Message msg) {
        log.debug("Publishing message: {}", msg);
        amqpTemplate.convertAndSend(exchange, null, msg);
    }
}
