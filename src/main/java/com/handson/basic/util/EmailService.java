package com.handson.basic.util;


import com.handson.basic.model.Emails;
import com.handson.basic.model.MessageAndPhones;
import okhttp3.*;
import okhttp3.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Properties;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo("shacher150@gmail.com");
        message.setSubject("subject");
        message.setText("text");
        emailSender.send(message);
    }

    @Value("${sms.ms.url}")
    String SMS_MS_URL;
    OkHttpClient client = new OkHttpClient.Builder().build();

    @Autowired
    RestTemplate rTemplate;

    public String send(Emails emails) {
        return rTemplate.postForObject(SMS_MS_URL + "/api/email/", emails, String.class);
    }

}
