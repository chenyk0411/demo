package com.example.demo.beans;

import lombok.Data;

import java.io.Serializable;

@Data
public class RabbitMqMessage implements Serializable {
    private String meaageId;
    private String message;
}
