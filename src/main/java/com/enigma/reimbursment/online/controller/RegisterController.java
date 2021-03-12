package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Login;
import com.enigma.reimbursment.online.entities.Role;
import com.enigma.reimbursment.online.models.request.register.RegisterRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.register.RegisterResponse;
import com.enigma.reimbursment.online.services.LoginService;
import com.enigma.reimbursment.online.services.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/register")
@RestController
public class RegisterController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<RegisterResponse> add (@RequestBody @Valid RegisterRequest model) {
        System.out.println(model);
        Login entity = modelMapper.map(model, Login.class);

        Role role = roleService.findById(model.getRole().getId());
        entity.setRole(role);
        System.out.println(entity);

        entity = loginService.save(entity);
        System.out.println(entity);

        RegisterResponse data = modelMapper.map(entity,RegisterResponse.class);
        System.out.println(data);

        return ResponseMessage.success(data);
    }


}
