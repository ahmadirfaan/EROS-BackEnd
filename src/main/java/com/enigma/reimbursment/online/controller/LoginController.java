package com.enigma.reimbursment.online.controller;


import com.enigma.reimbursment.online.entities.Employee;
import com.enigma.reimbursment.online.entities.Login;
import com.enigma.reimbursment.online.models.request.login.LoginRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.login.LoginResponse;
import com.enigma.reimbursment.online.services.EmployeeService;
import com.enigma.reimbursment.online.services.LoginService;
import com.google.common.hash.Hashing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;


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

    @PostMapping("/encode")
    public ResponseMessage<String> testEncode(@RequestBody  LoginRequest request){
        String password = request.getPassword();
        String encode = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
        return ResponseMessage.success(encode);
    }

    @PostMapping
    public ResponseMessage<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        Login login = loginService.findByEmailAndPassword(request.getEmail(), request.getPassword());
        if (login == null) {
            return new ResponseMessage(400, "Username or password is wrong.");
        } else {
            LoginResponse response = modelMapper.map(login, LoginResponse.class);
            switch (login.getRole().getId()) {
                case 1:
                    return new ResponseMessage(200, "Login Success", response);
                case 2:
                    return new ResponseMessage(200, "Login Success", response);
                case 3:
                    return new ResponseMessage(200, "Login Success", response);
                case 4:
                    Employee employee = employeeService.findByIdLogin(login.getId());
                    if (employee.getVerifiedEmail() == null) {
                        return new ResponseMessage(200, "Username or password is wrong.");
                    } else if (employee.getVerifiedEmail() != null && employee.getVerifiedEmail()) {
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

    @PostMapping("/hash")
    public ResponseMessage<LoginResponse> login_hash(@RequestBody @Valid LoginRequest request) {
        Login login = loginService.findByEmailAndPassword(request.getEmail(), request.getPassword());
        if (login == null) {
            return new ResponseMessage(400, "Username or password is wrong.");
        } else {
            LoginResponse response = modelMapper.map(login, LoginResponse.class);
            switch (login.getRole().getId()) {
                case 1:
                    return new ResponseMessage(200, "Login Success", response);
                case 2:
                    return new ResponseMessage(200, "Login Success", response);
                case 3:
                    return new ResponseMessage(200, "Login Success", response);
                case 4:
                    Employee employee = employeeService.findByIdLogin(login.getId());
                    if (employee.getVerifiedEmail() == null) {
                        return new ResponseMessage(200, "Username or password is wrong.");
                    } else if (employee.getVerifiedEmail() != null && employee.getVerifiedEmail()) {
                        return new ResponseMessage(200, "Login Success", response);
                    }
                default:
                    return new ResponseMessage(200, "Username or password is wrong.");
            }
        }
    }

}
