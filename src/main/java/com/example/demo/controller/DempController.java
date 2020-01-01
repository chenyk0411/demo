package com.example.demo.controller;

import com.example.demo.beans.RabbitMqMessage;
import com.example.demo.beans.Result;
import com.example.demo.beans.entity.ImmeEmp;
import com.example.demo.beans.entity.ImmeUser;
import com.example.demo.service.EmpService;
import com.example.demo.service.MailService;
import com.example.demo.service.RabbitMqService;
import com.example.demo.util.StringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Log4j2
@RestController
@RequestMapping("/demo")
public class DempController {
    @Autowired
    RabbitMqService rabbitMqService;

    @Autowired
    EmpService empService;

    @Autowired
    HttpServletResponse response;

    @Autowired
    MailService mailService;

    private ObjectMapper mapper = new ObjectMapper();

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

    @RequestMapping("/sendMail")
    public Result sendMail(){
        log.info("发送邮件");
        String title = "明天晚上一起吃饭";
        String content = "四号同学，我是一号同学，哪里有广告了";
        String recever = "952227593@qq.com";
        mailService.sendMail(title,content,recever);
        return new Result(true,"发送信息成功！");
    }

    @RequestMapping("/login")
    public Result login(String paramStr){
        try{
            log.info("登录：{}",paramStr);
            if(StringUtil.isBlank(paramStr)){
                return new Result(false,"参数为空");
            }

            ImmeUser user = mapper.readValue(paramStr,ImmeUser.class);

            //String md5 = StringUtil.getND5(user.getPassword());
            //user.setPassword(md5);

            return empService.login(user);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new Result(false,"登录出错！");
    }
}
