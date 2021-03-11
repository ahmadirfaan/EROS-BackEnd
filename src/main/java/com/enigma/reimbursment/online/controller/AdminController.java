package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Admin;
import com.enigma.reimbursment.online.entities.Login;
import com.enigma.reimbursment.online.models.request.user.UserRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.admin.UserResponse;
import com.enigma.reimbursment.online.services.AdminService;
import com.enigma.reimbursment.online.services.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private ModelMapper modelMapper;

//    @PostMapping
//    public ResponseMessage<UserResponse> add(@RequestBody @Valid UserRequest model) {
//        Admin entity = modelMapper.map(model,Admin.class);
//        Login login = loginService.findById(model.getUsername());
//    }

}
