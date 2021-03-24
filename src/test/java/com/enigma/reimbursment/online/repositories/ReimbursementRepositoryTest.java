package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Reimbursement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
public class ReimbursementRepositoryTest {

    @Autowired
    private ReimbursementRepository repository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Test
    void shouldSave() {
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setId("1");
        reimbursement.setDateOfClaimSubmission(LocalDate.parse("2021-01-01"));
        reimbursement.setClaimFee(300000);
        reimbursement.setDisbursementDate(LocalDate.parse("2021-01-05"));
        reimbursement.setStatusReject(false);

    }

}
