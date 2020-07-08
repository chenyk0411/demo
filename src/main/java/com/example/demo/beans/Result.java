package com.example.demo.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
public class Result {
    private String msg;
    private boolean success;
    private Object data;
    private Integer code;

    public Result(boolean success){
        this.success = success;
    }

    public Result(boolean success,String msg){
        this.success = success;
        this.msg = msg;
    }

    public Result(boolean success,String msg,Integer code){
        this.success = success;
        this.msg = msg;
        this.code = code;
    }

    public Result(boolean success,Object data){
        this.success = success;
        this.data = data;
    }

    public Result(boolean success,String msg,Object data){
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Result{" +
                "msg='" + msg + '\'' +
                ", success=" + success +
                ", data=" + data +
                '}';
    }
}
