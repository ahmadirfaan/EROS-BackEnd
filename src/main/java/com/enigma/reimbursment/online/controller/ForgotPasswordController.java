package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Employee;
import com.enigma.reimbursment.online.entities.Login;
import com.enigma.reimbursment.online.models.request.forgotPassword.ForgotPasswordRequest;
import com.enigma.reimbursment.online.models.request.login.LoginRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.login.LoginResponse;
import com.enigma.reimbursment.online.services.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/login")
@RestController
public class ForgotPasswordController {

    @Autowired
    private Employee loginService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<LoginResponse> forgotPassword(@RequestBody @Valid ForgotPasswordRequest request) {
        return null;
    }

}

