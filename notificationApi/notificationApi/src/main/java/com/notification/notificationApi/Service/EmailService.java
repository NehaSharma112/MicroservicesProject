package com.notification.notificationApi.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.util.Properties;

public class EmailService {

    private final JavaMailSenderImpl mailSender;
    public EmailService(){
        this.mailSender = new JavaMailSenderImpl();
        this.mailSender.setHost("smtp.gmail.com");
        this.mailSender.setPort(587);
        this.mailSender.setUsername("nehalecjava@gmail.com");
        this.mailSender.setPassword("cpuxudyeyvmlbrgu");

        //set properties
        Properties props = this.mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
    }

    public void sendHtmlEmail(String to, String subject, String text) throws MessagingException {
        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setTo(to);
        helper.setSubject(subject);

        helper.setText(text,true);

        mailSender.send(mimeMessage);
    }
}
