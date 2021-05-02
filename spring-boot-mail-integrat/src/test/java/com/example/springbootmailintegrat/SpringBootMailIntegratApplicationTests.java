package com.example.springbootmailintegrat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringBootMailIntegratApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    /**
     * 测试邮箱发送：
     */
    @Test
    void contextLoads() {
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
    @Test
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
