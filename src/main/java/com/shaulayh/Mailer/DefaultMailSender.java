package com.shaulayh.Mailer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


public class DefaultMailSender implements MailSender {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void send(String from, String to, String subject) {
        logger.info("Sending mail from " + from);
        logger.info("Sending mail to " + to);
        logger.warn("Sending mail with subject" + subject);
    }
}
