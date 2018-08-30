package com.shaulayh.Mailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Configuration
public class MailConfig {


    @Bean
    @Profile("dev")
    public MailSender DefaultMailSender() {
        return new DefaultMailSender();
    }

    @Bean
    @Profile("!dev")
    public MailSender SmtpMailSender(JavaMailSender javaMailSender) {
        return new SmtpMailSender(javaMailSender);
    }
}
