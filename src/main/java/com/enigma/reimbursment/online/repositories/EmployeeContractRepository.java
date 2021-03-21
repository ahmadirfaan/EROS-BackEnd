package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.EmployeeContract;
import com.enigma.reimbursment.online.entities.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeContractRepository extends JpaRepository<EmployeeContract,String> {

    }
