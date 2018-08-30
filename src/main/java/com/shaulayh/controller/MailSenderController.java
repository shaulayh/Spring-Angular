package com.shaulayh.controller;

import com.shaulayh.Mailer.MailSender;
import com.sun.mail.iap.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.security.auth.login.Configuration;

@RestController
public class MailSenderController {

    @Autowired
    private MailSender mailSender;

    MailSenderController(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @RequestMapping(value = "/api-public/v1/contact/submission", method = RequestMethod.PUT)
    public Integer sendMail(@RequestBody Contact request) throws MessagingException {
        mailSender.send(request.message, request.email, request.subject);
        return Response.OK;
    }

    @RequestMapping("/check")
    public String check() {
        return "index";
    }

    public static class Contact {
        public String email;
        public String subject;
        public String message;

    }
}
