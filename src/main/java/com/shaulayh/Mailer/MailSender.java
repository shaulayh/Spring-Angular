package com.shaulayh.Mailer;

import javax.mail.MessagingException;

public interface MailSender {

    void send(String text, String to, String subject) throws MessagingException;
}
