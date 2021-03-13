package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Category;
import com.enigma.reimbursment.online.entities.Employee;
import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.models.request.reimbursements.ReimbursementRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.reimbursement.ReimbursementResponse;
import com.enigma.reimbursment.online.services.CategoryService;
import com.enigma.reimbursment.online.services.EmployeeService;
import com.enigma.reimbursment.online.services.ReimbursementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/reimburse")
@RestController
public class ReimbursementController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ReimbursementService reimbursementService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<ReimbursementResponse> add(@RequestBody @Valid ReimbursementRequest model) {
        Reimbursement reimbursement = modelMapper.map(model,Reimbursement.class);
        Category category = categoryService.findById(model.getCategoryId());
        Employee employee = employeeService.findById(model.getEmployeeId());
        reimbursement.setEmployeeId(employee);
        reimbursement.setCategoryId(category);
        reimbursement = reimbursementService.save(reimbursement);

        ReimbursementResponse response = modelMapper.map(reimbursement,ReimbursementResponse.class);
        return ResponseMessage.success(response);






    }
}
