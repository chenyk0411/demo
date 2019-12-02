package com.example.demo.service.impl;

import com.example.demo.beans.RabbitMqMessage;
import com.example.demo.service.RabbitMqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMqServiceImpl implements RabbitMqService {
    private String defaultExchange;
    private String defaultRoutingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(RabbitMqMessage rabbitMqMessage) {
        log.info("发送rabbitMq:{}",rabbitMqMessage.getMeaageId());
        rabbitTemplate.convertAndSend(rabbitMqMessage);
    }
}
