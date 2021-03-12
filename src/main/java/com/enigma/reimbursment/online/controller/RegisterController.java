package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Admin;
import com.enigma.reimbursment.online.entities.Login;
import com.enigma.reimbursment.online.entities.Role;
import com.enigma.reimbursment.online.models.request.register.RegisterAdminRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.login.LoginResponse;
import com.enigma.reimbursment.online.services.AdminService;
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
    private AdminService adminService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/admin")
    public ResponseMessage<LoginResponse> register_admin (@RequestBody @Valid RegisterAdminRequest model) {

        /* Save data register to table login */
        Login login = modelMapper.map(model, Login.class);
        Role role = roleService.findById(model.getRoleId());
        login.setRole(role);
        login = loginService.save(login);

        /* Save data register to table admin */
        Admin admin = new Admin();
        admin.setLogin(login);
        admin.setName(model.getName());
        adminService.save(admin);

        LoginResponse response = modelMapper.map(login, LoginResponse.class);
        return ResponseMessage.success(response);
    }


}
