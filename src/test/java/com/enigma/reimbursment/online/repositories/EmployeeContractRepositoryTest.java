package com.enigma.reimbursment.online.repositories;


import com.enigma.reimbursment.online.entities.EmployeeContract;
import com.enigma.reimbursment.online.enums.StatusRegistrationBenefit;
import com.enigma.reimbursment.online.enums.TypeOfContract;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
public class EmployeeContractRepositoryTest {

    @Autowired
    private EmployeeContractRepository repository;

    @Test
    void shouldSave(){
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
        employeeContract = repository.save(employeeContract);

        EmployeeContract saved = repository.findById(employeeContract.getId()).get();
        Assertions.assertEquals(employeeContract,saved);

    }
}
