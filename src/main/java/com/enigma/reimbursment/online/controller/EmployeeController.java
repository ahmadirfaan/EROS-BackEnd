package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Admin;
import com.enigma.reimbursment.online.entities.Employee;
import com.enigma.reimbursment.online.entities.Login;
import com.enigma.reimbursment.online.entities.Role;
import com.enigma.reimbursment.online.models.request.register.RegisterAdminRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.login.LoginResponse;
import com.enigma.reimbursment.online.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseMessage<LoginResponse> register (@RequestBody @Valid RegisterAdminRequest model) {
        Employee employee = modelMapper.map(model, Employee.class);
        LoginResponse response = modelMapper.map(employee, LoginResponse.class);
        return ResponseMessage.success(response);
    }
}
