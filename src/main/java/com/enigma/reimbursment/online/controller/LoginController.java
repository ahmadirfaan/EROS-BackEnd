package com.enigma.reimbursment.online.controller;


import com.enigma.reimbursment.online.entities.Login;
import com.enigma.reimbursment.online.exceptions.EntityNotFondException;
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
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        Login login = loginService.findByEmailAndPassword(request.getEmail(), request.getPassword());

        if (login != null) {
            LoginResponse response = new LoginResponse();
            response.setEmail(login.getEmail());
            response.setPassword(login.getPassword());
            response.setRoleId(login.getRole().getId());
            return new ResponseMessage(200, "Login Success", response);
        } else {
            return new ResponseMessage(200, "Username or password is wrong.");
        }
    }


}
