package com.enigma.reimbursment.online.repositories;


import com.enigma.reimbursment.online.entities.EmployeeContract;
import com.enigma.reimbursment.online.enums.StatusRegistrationBenefit;
import com.enigma.reimbursment.online.enums.TypeOfContract;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertEquals(employeeContract,saved);
    }

    @Test
    void testFindById() {
        Optional<EmployeeContract> employeeContractOptional = repository.findById("1");
        assertTrue(employeeContractOptional.isPresent());
    }

    @Test
    void testFindAll() {
        List<EmployeeContract> optional = repository.findAll();
        assertEquals(4,optional.size());
    }

    @Test
    void shouldUpdateEmployeeContract() {
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

        EmployeeContract update = new EmployeeContract();
        update.setId("1");
        update.setEmployeeId(update.getEmployeeId());
        update.setTypeContract(TypeOfContract.PKWT);
        update.setBenefitRegistrationStatus(StatusRegistrationBenefit.ON_PROCESS);
        update.setStartDateContract(LocalDate.parse("2021-12-01"));
        update.setEndedContract(true);
        update.setDateOfAcceptancePermanentEmployee(LocalDate.parse("2021-02-05"));
        update.setDateOfResignation(LocalDate.parse("2021-02-09"));
        update.setPlacement("jkt");

        EmployeeContract result = repository.findById(employeeContract.getId()).get();
        assertThat(result.getId()).isEqualTo(update.getId());
        assertThat(result.getEmployeeId()).isEqualTo(update.getEmployeeId());
        assertThat(result.getTypeContract()).isEqualTo(update.getTypeContract());
        assertThat(result.getBenefitRegistrationStatus()).isEqualTo(update.getBenefitRegistrationStatus());
        assertThat(result.getStartDateContract()).isEqualTo(update.getStartDateContract());
        assertThat(result.getEndDateContract()).isEqualTo(update.getEndDateContract());
        assertThat(result.getEndedContract()).isEqualTo(update.getEndedContract());
        assertThat(result.getPlacement()).isEqualTo(update.getPlacement());
        assertThat(result.getDateOfAcceptancePermanentEmployee()).isEqualTo(update.getDateOfAcceptancePermanentEmployee());
        assertThat(result.getDateOfResignation()).isEqualTo(update.getDateOfResignation());
    }



}
