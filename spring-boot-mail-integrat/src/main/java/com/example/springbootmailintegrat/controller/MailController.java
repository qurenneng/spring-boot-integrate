package com.example.springbootmailintegrat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @Author qrn
 * @Date 2021/5/2 上午11:41
 * @Version 1.0
 * @blog https://blog.csdn.net/qq_41971087
 */
@RestController
public class MailController {

    @Autowired
    JavaMailSenderImpl javaMailSender;


    /**
     * 测试邮箱发送：
     */
    @RequestMapping("/contextLoads")
    public  void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("测试邮件服务");
        simpleMailMessage.setText("这是一封用来测试邮件的服务");
        simpleMailMessage.setTo("1796789910@qq.com");
        simpleMailMessage.setFrom("miraitowa1796@163.com");
        javaMailSender.send(simpleMailMessage);
    }


    /**
     * 发送带附件或者html的邮件
     */
    @RequestMapping("/contextFileLoads")
    void contextFileLoads() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("通知今晚开会");
        helper.setText("<p>这是一个带附件的html文件</p>",true);
        helper.setTo("1796789910@qq.com");
        //要上传的文件：
        FileSystemResource file = new FileSystemResource(new File("c:/Sample.jpg"));
        helper.addAttachment("test.jpg", file);
        javaMailSender.send(mimeMessage);
    }

}
