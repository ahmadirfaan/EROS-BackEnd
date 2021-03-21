package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.EmployeeContract;
import com.enigma.reimbursment.online.repositories.EmployeeContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeContractService extends AbstractService<EmployeeContract,String> {

    @Autowired
    EmployeeContractRepository repository;

   @Autowired
    protected EmployeeContractService(EmployeeContractRepository repository){
       super(repository);
   }

}
