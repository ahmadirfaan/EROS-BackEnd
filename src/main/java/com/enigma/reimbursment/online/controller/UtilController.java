package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.employee.EmployeeResponseDashboard;
import com.enigma.reimbursment.online.services.CategoryService;
import com.enigma.reimbursment.online.services.EmployeeService;
import com.enigma.reimbursment.online.services.ReimbursementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UtilController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ReimbursementService reimbursementService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/dashboard")
    public ResponseMessage<EmployeeResponseDashboard> employeeDashboards(){
        EmployeeResponseDashboard responseDashboard = employeeService.employeeDashboard();
        responseDashboard.setCountDataDashboard((responseDashboard.getCountEmployeeActive()/ responseDashboard.getCountEmployee())*100);
        return ResponseMessage.success(responseDashboard);



    }
}
