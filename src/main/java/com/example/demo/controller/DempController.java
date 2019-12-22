package com.example.demo.controller;

import com.example.demo.beans.RabbitMqMessage;
import com.example.demo.beans.Result;
import com.example.demo.beans.entity.ImmeEmp;
import com.example.demo.service.EmpService;
import com.example.demo.service.RabbitMqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DempController {
    @Autowired
    RabbitMqService rabbitMqService;

    @Autowired
    EmpService empService;

    @Autowired
    HttpServletResponse response;

    @RequestMapping("/send")
    public Result send(){
        log.info("rabbitMq测试");

        RabbitMqMessage message = new RabbitMqMessage();
        message.setMeaageId("msg"+new Date().getTime());
        message.setMessage("一号同学，我是四号同学，有内鬼，今晚交易取消，收到请回复！");
        rabbitMqService.sendMessage(message);

        return new Result(true,"发送信息成功！");
    }

    @RequestMapping("/getAllEmp")
    public Result getAllEmp(){
        List<ImmeEmp> allEmps = empService.getAllEmp();
        log.info("查询到所有的用户数量：{}",allEmps.size());
        return new Result(true,allEmps);
    }
}
