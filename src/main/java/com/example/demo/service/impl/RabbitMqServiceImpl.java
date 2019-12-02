package com.example.demo.service.impl;

import com.example.demo.beans.RabbitMqMessage;
import com.example.demo.service.RabbitMqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMqServiceImpl implements RabbitMqService {
    @Value("${rabbitmq.defaultExchange}")
    private String defaultExchange;

    @Value("${rabbitmq.defaultRoutingKey}")
    private String defaultRoutingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(RabbitMqMessage rabbitMqMessage) {
        log.info("发送rabbitMq:{},defaultExchange:{},defaultRoutingKey:{}",rabbitMqMessage.getMeaageId(),defaultExchange,defaultRoutingKey);

        CorrelationData data = new CorrelationData();
        data.setId(rabbitMqMessage.getMeaageId());

        log.info("messgge:{}",rabbitMqMessage.toString());

        rabbitTemplate.convertAndSend(defaultExchange,defaultRoutingKey,rabbitMqMessage,data);
    }
}
