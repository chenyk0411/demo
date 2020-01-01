package com.example.demo.service.impl;

import com.example.demo.service.MailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Service
@Log4j2
public class MailServiceImpl implements MailService {
    private String senderName = "四号同学";

    @Value("${mail.smtpHost}")
    private String smtpHost;

    @Value("${mail.smtpPort}")
    private String smtpPort;

    @Value("${mail.emailAccount}")
    private String emailAccount;

    @Value("${mail.emailPassword}")
    private String emailPassword;

    public MimeMessage createMimeMessage(String title,String content,String receiveMail,String receverName) throws Exception{
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", smtpHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");

        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", "465");

        // 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);// 设置为debug模式, 可以查看详细的发送 log


        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人
        message.setFrom(new InternetAddress(emailAccount, senderName, "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, receverName, "UTF-8"));

        // 4. Subject: 邮件主题
        message.setSubject(title, "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent(content, "text/html;charset=UTF-8");

        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        // 根据 Session 获取邮件传输对象
        Transport transport = session.getTransport();

        transport.connect(emailAccount, emailPassword);

        //发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(message, message.getAllRecipients());

        //关闭连接
        transport.close();

        return message;
    }

    @Override
    public boolean sendMail(String title, String content, String recevers) {
        try {
            log.info("title:{}",title);
            log.info("content:{}",content);

            createMimeMessage(title,content,recevers,"");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("",e);
        }
        return false;
    }
}
