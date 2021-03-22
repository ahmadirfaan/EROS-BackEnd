package com.enigma.reimbursment.online.controller;


import com.enigma.reimbursment.online.entities.Employee;
import com.enigma.reimbursment.online.entities.EmployeeContract;
import com.enigma.reimbursment.online.entities.Grade;
import com.enigma.reimbursment.online.enums.StatusRegistrationBenefit;
import com.enigma.reimbursment.online.enums.TypeOfContract;
import com.enigma.reimbursment.online.exceptions.EntityNotFoundException;
import com.enigma.reimbursment.online.models.request.employee.EmployeeContractRequest;
import com.enigma.reimbursment.online.models.request.employee.FindIdEmployeeRequest;
import com.enigma.reimbursment.online.models.request.grade.GradeRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.employee.EmployeeContractResponse;
import com.enigma.reimbursment.online.models.response.grade.GradeResponse;
import com.enigma.reimbursment.online.services.EmployeeContractService;
import com.enigma.reimbursment.online.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/contract")
@RestController
public class EmployeeContractController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeContractService employeeContractService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<EmployeeContractResponse> add(@RequestBody EmployeeContractRequest request) throws ParseException {

        EmployeeContract employeeContract = modelMapper.map(request,EmployeeContract.class);

//        employeeContract.setTypeContract(TypeOfContract.getTypeOfContract(request.getTypeContract()));
//        employeeContract.setBenefitRegistrationStatus(StatusRegistrationBenefit
//                .getStatusRegistrationBenefit(request.getBenefitRegistrationStatus()));
        employeeContract.setStartDateContract(LocalDate.parse(request.getStartDateContract(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        employeeContract.setEndDateContract(LocalDate.parse(request.getEndDateContract(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        employeeContract.setDateOfAcceptancePermanentEmployee(LocalDate.parse(request.getDateOfAcceptancePermanentEmployee(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        employeeContract.setDateOfResignation(LocalDate.parse(request.getDateOfResignation(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        Employee employee = employeeService.findById(request.getEmployeeId());
        employeeContract.setEmployeeId(employee);


        employeeContract = employeeContractService.save(employeeContract);
        System.out.println("employee contract :" +employeeContract);

        EmployeeContractResponse data = modelMapper.map(employeeContract,EmployeeContractResponse.class);
        System.out.println("data:" +data);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<EmployeeContractResponse> findById(@PathVariable String id) {
        EmployeeContract employeeContract = employeeContractService.findById(id);

        if(employeeContract == null) {
            throw new EntityNotFoundException();
        }

        EmployeeContractResponse data = modelMapper.map(employeeContract,EmployeeContractResponse.class);
        return ResponseMessage.success(data);
    }




    @PutMapping("/{id}")
    public ResponseMessage<EmployeeContractResponse> edit(@PathVariable String id, @Valid EmployeeContractRequest request)  {
        System.out.println(request);
        System.out.println(id);

        EmployeeContract employeeContract = employeeContractService.findById(id);
        System.out.println(employeeContract);
        if(employeeContract == null) {
            throw new EntityNotFoundException();
        }
        employeeContract = employeeContractService.save(employeeContract);

        EmployeeContractResponse data = modelMapper.map(employeeContract,EmployeeContractResponse.class);
        return ResponseMessage.success(data);

    }


    @GetMapping
    public ResponseMessage<List<EmployeeContractResponse>> getAll(){
        List<EmployeeContract> employeeContracts = employeeContractService.findAll();
        List<EmployeeContractResponse> employeeContractResponseList = employeeContracts.stream().map(e ->modelMapper
                .map(e,EmployeeContractResponse.class)).collect(Collectors.toList());
        return ResponseMessage.success(employeeContractResponseList);

    }
}
