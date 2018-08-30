package com.shaulayh.Mailer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


public class SmtpMailSender implements MailSender {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private JavaMailSender javaMailSender;

    public SmtpMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    @Override
    public void send(String text, String to, String subject) throws MessagingException {
        logger.warn(text);
        logger.warn(to);
        logger.warn(subject);
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        mimeMessageHelper = new MimeMessageHelper(message, true);

        mimeMessageHelper.setTo("shaulayh@gmail.com");
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text);

        javaMailSender.send(message);
    }

}
