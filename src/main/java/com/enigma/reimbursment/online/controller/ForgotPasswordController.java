package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Employee;
import com.enigma.reimbursment.online.entities.Login;
import com.enigma.reimbursment.online.models.request.forgotPassword.ForgotPasswordRequest;
import com.enigma.reimbursment.online.models.request.login.LoginRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.login.LoginResponse;
import com.enigma.reimbursment.online.services.LoginService;
import com.enigma.reimbursment.online.services.SendEmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.Random;


@RequestMapping("/forgot-password")
@RestController
public class ForgotPasswordController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    SendEmailService emailService;

    @Autowired
    private SendEmailService sendEmailService;



    @PostMapping
    public ResponseEntity<String> forgotPassword(@RequestBody @Valid ForgotPasswordRequest request) throws MessagingException {
        Integer user = loginService.findByEmail(request.getEmail());
        if (user != 0) {
            sendEmailService.sendMail(getSaltString());
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.ok("Failed");
        }
    }


    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() <= 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}

