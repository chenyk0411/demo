package com.example.demo.beans;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

@Data
@Log4j2
public class RabbitMqMessage implements Serializable {
    private String meaageId;
    private String message;

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            log.error("转成json出错：",e);
            e.printStackTrace();
        }

        return "RabbitMqMessage{" +
                "meaageId='" + meaageId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
