package com.example.demo.service;

import com.example.demo.beans.RabbitMqMessage;

public interface RabbitMqService {
    /**
     * 发送MQ
     * @param rabbitMqMessage
     */
    void sendMessage(RabbitMqMessage rabbitMqMessage);
}
