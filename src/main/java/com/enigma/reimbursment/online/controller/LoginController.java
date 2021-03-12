package com.enigma.reimbursment.online.controller;


import com.enigma.reimbursment.online.entities.Login;
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
    public ResponseMessage<LoginResponse> login (@RequestBody @Valid LoginRequest model) {
        System.out.println(model);
        Login entity = loginService.findByUsernameAndPassword(model.getUsername(),model.getPassword());
        System.out.println(entity);

        LoginResponse data = modelMapper.map(entity,LoginResponse.class);
        System.out.println(data);

        return ResponseMessage.success(data);
    }


}
