package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Employee;
import com.enigma.reimbursment.online.entities.Login;
import com.enigma.reimbursment.online.exceptions.EntityNotFoundException;
import com.enigma.reimbursment.online.models.pagination.PageList;
import com.enigma.reimbursment.online.models.request.employee.EmployeeRequest;
import com.enigma.reimbursment.online.models.request.employee.EmployeeSearch;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.employee.EmployeeResponsePage;
import com.enigma.reimbursment.online.models.response.employee.EmployeeResponse;
import com.enigma.reimbursment.online.services.EmployeeService;
import com.enigma.reimbursment.online.services.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RequestMapping("/employee")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    LoginService loginService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/{id}")
    public ResponseMessage<EmployeeResponse> findById(@Valid @PathVariable String id) {
        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new EntityNotFoundException();
        }

        EmployeeResponse response = modelMapper.map(employee, EmployeeResponse.class);
        return ResponseMessage.success(response);
    }


    @GetMapping
    public ResponseMessage<PageList<EmployeeResponse>> findAll(@Valid EmployeeSearch request) {
        Employee employee = modelMapper.map(request, Employee.class);

        Page<Employee> pagination = employeeService.findAll(employee, request.getPage(),
                request.getSize(), request.getSort());
        System.out.println(pagination);
        List<EmployeeResponse> employeResponsePageList = pagination.stream()
                .map(e -> modelMapper.map(e, EmployeeResponse.class))
                .collect(Collectors.toList());
        PageList<EmployeeResponse> response = new PageList(employeResponsePageList,
                pagination.getNumber(), pagination.getSize(), pagination.getTotalElements());
        System.out.println(employeResponsePageList);
        return new ResponseMessage(200, "OK", response);
    }


    @PostMapping
    public ResponseMessage<EmployeeResponse> add(@RequestBody @Valid EmployeeRequest request) {
        Employee employee = modelMapper.map(request, Employee.class);
        Login login = loginService.findById(request.getIdLogin());
        employee.setIdLogin(login);

        employee = employeeService.save(employee);
        EmployeeResponse response = modelMapper.map(employee, EmployeeResponse.class);
        return ResponseMessage.success(response);
    }


    @PutMapping("/{id}")
    public ResponseMessage<EmployeeResponse> edit(@PathVariable String id,
                                                  @RequestBody @Valid EmployeeRequest request) {

        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new EntityNotFoundException();
        }

        Login login = loginService.findById(id);
        employee.setIdLogin(login);

        modelMapper.map(request, employee);
        employee = employeeService.save(employee);

        EmployeeResponse response = modelMapper.map(employee, EmployeeResponse.class);
        return ResponseMessage.success(response);
    }


    @PutMapping("/{id}/changeStatusEmployee")
    public ResponseMessage<Boolean> changeStatusEmployee(@PathVariable String id) {
        return null;
    }
}
