package com.enigma.reimbursment.online.controllers;

import com.enigma.reimbursment.online.controller.EmployeeContractController;
import com.enigma.reimbursment.online.entities.EmployeeContract;
import com.enigma.reimbursment.online.entities.Grade;
import com.enigma.reimbursment.online.enums.StatusRegistrationBenefit;
import com.enigma.reimbursment.online.enums.TypeOfContract;
import com.enigma.reimbursment.online.models.response.grade.GradeResponse;
import com.enigma.reimbursment.online.services.EmployeeContractService;
import com.enigma.reimbursment.online.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeContractController.class)
public class EmployeeContractControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeContractService service;

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private ModelMapper modelMapper;

    @Test
    void addShouldSuccess() throws Exception {
        EmployeeContract employeeContract = new EmployeeContract();
        employeeContract.setId("1");
        employeeContract.setEmployeeId(employeeContract.getEmployeeId());
        employeeContract.setTypeContract(TypeOfContract.PKWT);
        employeeContract.setBenefitRegistrationStatus(StatusRegistrationBenefit.ON_PROCESS);
        employeeContract.setStartDateContract(LocalDate.parse("2021-12-01"));
        employeeContract.setEndedContract(true);
        employeeContract.setDateOfAcceptancePermanentEmployee(LocalDate.parse("2021-02-05"));
        employeeContract.setDateOfResignation(LocalDate.parse("2021-02-09"));
        employeeContract.setPlacement("jkt");
        when(service.save(any())).thenReturn(employeeContract);

        EmployeeContract contract = new EmployeeContract();
        contract.setId((employeeContract.getId()));
        contract.setEmployeeId(employeeContract.getEmployeeId());
        contract.setTypeContract(employeeContract.getTypeContract());
        contract.setBenefitRegistrationStatus(employeeContract.getBenefitRegistrationStatus());
        contract.setStartDateContract(employeeContract.getStartDateContract());
        contract.setEndDateContract(employeeContract.getEndDateContract());
        contract.setEndedContract(employeeContract.getEndedContract());
        contract.setDateOfAcceptancePermanentEmployee(employeeContract.getDateOfAcceptancePermanentEmployee());
        contract.setDateOfResignation(employeeContract.getDateOfResignation());
        contract.setPlacement(employeeContract.getPlacement());
        when(modelMapper.map(any(EmployeeContract.class),any(Class.class))).thenReturn(contract);



        RequestBuilder requestBuilder = post("/contract")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"placement\" : \"jkt\"}");

        mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code", is(HttpStatus.OK.value())))
                .andExpect(jsonPath("$.data.placement", is(contract.getPlacement())));



    }
}
