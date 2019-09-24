package com.example.demo.beans;

public class Result {
    private String msg;
    private boolean success;
    private Object data;

    public Result(boolean success){
        this.success = success;
    }

    public Result(boolean success,String msg){
        this.success = success;
        this.msg = msg;
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

    public String toString(){
        return null;
    }
}
