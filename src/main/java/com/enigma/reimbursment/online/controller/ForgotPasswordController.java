package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Login;
import com.enigma.reimbursment.online.models.model.forgotPassword.ForgotPasswordModel;
import com.enigma.reimbursment.online.services.LoginService;
import com.enigma.reimbursment.online.services.SendEmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ForgotPasswordModel> forgotPassword(@RequestBody @Valid ForgotPasswordModel request) throws MessagingException {

        /* Find email in table login */
        Login login = loginService.findByEmail(request.getEmail());

        if (login != null) {
            String newPassword = randomString();

            /* Send Mail */
            sendEmailService.sendEmailForgotPassword(newPassword, request.getEmail());

            /* Reset Password */
            loginService.resetPassword(login.getId(), newPassword);

            /* Set Response */
            ForgotPasswordModel response = new ForgotPasswordModel();
            response.setEmail(request.getEmail());
            response.setStatus("Success");
            return ResponseEntity.ok(response);
        } else {
            ForgotPasswordModel response = new ForgotPasswordModel();
            response.setEmail(request.getEmail());
            response.setStatus("Failed");
            return ResponseEntity.ok(response);
        }
    }


    protected String randomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        Random rnd = new Random();

        while (stringBuilder.length() <= 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * characters.length());
            stringBuilder.append(characters.charAt(index));
        }

        return stringBuilder.toString();
    }
}

