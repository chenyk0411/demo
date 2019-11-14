package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class RabbitMqUtil {
    private String defaultRoutingKey;
    private String defaultExchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String messageId,Object message) throws Exception{
        log.info("发送rabbitMq:{}",messageId);
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(messageId);

        rabbitTemplate.convertAndSend(defaultExchange,defaultRoutingKey,message,correlationData);
    }
}
