package com.example.demo.beans;

import lombok.Data;

@Data
public class JobParamDto {
    private String jobName;
    private String jobClassName;
    private String jobGroupName;
    private String cronExpression;
}
