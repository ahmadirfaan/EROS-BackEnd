package com.enigma.reimbursment.online.services;


import com.enigma.reimbursment.online.entities.EmployeeContract;
import com.enigma.reimbursment.online.enums.StatusRegistrationBenefit;
import com.enigma.reimbursment.online.enums.TypeOfContract;
import com.enigma.reimbursment.online.repositories.EmployeeContractRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeContractServiceTest {

    @InjectMocks
    private EmployeeContractService service;

    @Mock
    private EmployeeContractRepository repository;

    @Test
    void shouldSave(){
        EmployeeContract input = new EmployeeContract();
        input.setId("1");
        input.setEmployeeId(input.getEmployeeId());
        input.setTypeContract(TypeOfContract.PKWT);
        input.setBenefitRegistrationStatus(StatusRegistrationBenefit.ON_PROCESS);
        input.setStartDateContract(LocalDate.parse("2021-12-01"));
        input.setEndedContract(true);
        input.setDateOfAcceptancePermanentEmployee(LocalDate.parse("2021-02-05"));
        input.setDateOfResignation(LocalDate.parse("2021-02-09"));
        input.setPlacement("jkt");

        EmployeeContract output = new EmployeeContract();
        output.setId("1");
        output.setEmployeeId(output.getEmployeeId());
        output.setTypeContract(TypeOfContract.PKWT);
        output.setBenefitRegistrationStatus(StatusRegistrationBenefit.ON_PROCESS);
        output.setStartDateContract(LocalDate.parse("2021-12-01"));
        output.setEndedContract(true);
        output.setDateOfAcceptancePermanentEmployee(LocalDate.parse("2021-02-05"));
        output.setDateOfResignation(LocalDate.parse("2021-02-09"));
        output.setPlacement("jkt");

        when(repository.save(any())).thenReturn(output);
        EmployeeContract result = service.save(input);
        assertEquals(output,result);
    }

    @Test
    void shouldFindById() {
        EmployeeContract input = new EmployeeContract();
        input.setId("1");
        when(repository.findById(anyString()))
                .thenReturn(Optional.of(input));
        EmployeeContract result = service.findById(input.getId());
        assertEquals(input,result);
    }

    @Test
    void shouldFindAll() {
        List<EmployeeContract> employeeContracts = new ArrayList();
        employeeContracts.add(new EmployeeContract("1"));
        employeeContracts.add(new EmployeeContract("2"));
        employeeContracts.add(new EmployeeContract("3"));
        when(service.findAll()).thenReturn(employeeContracts);
        List<EmployeeContract> expected = service.findAll();
        assertEquals(employeeContracts,expected);
    }
}
