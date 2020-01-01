package com.example.demo.controller;

import com.example.demo.beans.JobParamDto;
import com.example.demo.beans.Result;
import com.example.demo.util.CommUtil;
import com.example.demo.util.StringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/job")
public class JobController {
    @Autowired
    @Qualifier("scheduler")
    private Scheduler scheduler;

    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping("/addJob")
    public Result addJob(String paramStr){
        try {
            log.info("新增定时任务:{}",paramStr);

            if(!StringUtil.isNotBlank(paramStr)){
                log.info("参数为空");
                return new Result(false,"参数为空！");
            }

            JobParamDto paramDto = mapper.readValue(paramStr,JobParamDto.class);

            // 启动调度器
            scheduler.start();

            //构建job信息
            JobDetail jobDetail = JobBuilder.newJob(getClass(paramDto.getJobClassName()).getClass())
                    .withIdentity(paramDto.getJobName(), paramDto.getJobGroupName()).build();

            //表达式调度构建器(即任务执行的时间)
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(paramDto.getCronExpression());

            //按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(paramDto.getJobName(), paramDto.getJobGroupName())
                    .withSchedule(scheduleBuilder).build();

            scheduler.scheduleJob(jobDetail, trigger);

        }catch (Exception e){
            log.error("",e);
            e.printStackTrace();
        }
        return null;
    }

    public Job getClass(String classname) throws Exception
    {
        Class<?> class1 = Class.forName(classname);
        return (Job)class1.newInstance();
    }
}
