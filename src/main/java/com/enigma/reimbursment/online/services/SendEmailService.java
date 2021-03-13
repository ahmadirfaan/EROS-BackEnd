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

    public void sendEmailForgotPassword(String randomKey, String to) throws MessagingException {
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


    public void sendEmailVerificationToken(String token, String to) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
        String message = "<h3>Click link below to activation your account.</h3>"+
                "<a href='http://localhost:8080/register/verification/"+token+"'>"+
                    "http://localhost:8080/register/verification/"+token+
                "</a>";
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject("Verification Email");
        mimeMessageHelper.setText(message, true);
        javaMailSender.send(mimeMessage);
    }
}
