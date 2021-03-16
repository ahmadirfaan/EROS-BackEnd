package com.enigma.reimbursment.online.controller;


import com.enigma.reimbursment.online.entities.Employee;
import com.enigma.reimbursment.online.entities.Login;
import com.enigma.reimbursment.online.models.request.login.LoginRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.login.LoginResponse;
import com.enigma.reimbursment.online.services.EmployeeService;
import com.enigma.reimbursment.online.services.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;


@RequestMapping("/login")
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseMessage<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        Login login = loginService.findByEmailAndPassword(request.getEmail(), request.getPassword());
        if (login == null) {
            return new ResponseMessage(200, "Username or password is wrong.");
        } else {
            LoginResponse response = new LoginResponse();
            response.setEmail(login.getEmail());
            response.setPassword(login.getPassword());
            response.setRoleId(login.getRole().getId());
            switch (login.getRole().getId()) {
                case 1:
                    return new ResponseMessage(200, "Login Success", response);
                case 2:
                    return new ResponseMessage(200, "Login Success", response);
                case 3:
                    return new ResponseMessage(200, "Login Success", response);
                case 4:
                    Employee employee = employeeService.findByIdLogin(login.getId());
                    if (employee.getIsVerifiedEmail() == null) {
                        return new ResponseMessage(200, "Username or password is wrong.");
                    } else if (employee.getIsVerifiedEmail() != null && employee.getIsVerifiedEmail()) {
                        return new ResponseMessage(200, "Login Success", response);
                    }
                default:
                    return new ResponseMessage(200, "Username or password is wrong.");
            }
        }
    }

    @GetMapping("/test")
    public Object test() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        Object object = restTemplate.getForObject(url, Object.class);
        return object;
    }

}
