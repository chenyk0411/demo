package com.example.demo.controller;

import com.example.demo.beans.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DempController {

    @RequestMapping("/send")
    public Result send(){
        log.info("rabbitMq测试");
        return new Result(false);
    }
}
