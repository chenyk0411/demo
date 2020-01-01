package com.example.demo.service;

public interface MailService {
    /**
     * 发送邮件
     * @param title
     * @param content
     * @param recevers
     * @return
     */
    boolean sendMail(String title,String content,String recevers);
}
