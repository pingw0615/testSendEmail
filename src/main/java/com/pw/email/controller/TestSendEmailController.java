package com.pw.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author pingwei
 * @Date 12/9/21
 * @Remark
 */
@Controller
public class TestSendEmailController {

    @Autowired
    private JavaMailSender javaMailSender;


    @RequestMapping("/sendEmail")
    @ResponseBody
    public String testSendEmail(){
        // 要发送的消息内容
        SimpleMailMessage message = new SimpleMailMessage();
        // 发送者
        message.setFrom("XXXXX@qq.com");
        // 接收者
        message.setTo("XXXXX@qq.com");
        // 邮件主题
        message.setSubject("test主题");
        // 邮件内容
        message.setText("test内容");


        // 发送邮件
        this.javaMailSender.send(message);
        return "success";
    }
}
