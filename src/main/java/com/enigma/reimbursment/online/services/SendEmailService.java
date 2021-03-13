package com.enigma.reimbursment.online.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String randomKey, String to) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
        String message = "<h3>" +
                randomKey +
                "</h3>";
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject("Forgot Password");
        mimeMessageHelper.setText(message, true);
        javaMailSender.send(mimeMessage);
    }
}
