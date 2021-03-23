package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.EmployeeContract;
import com.enigma.reimbursment.online.models.response.employee.EmployeeResponseDashboard;
import com.enigma.reimbursment.online.repositories.EmployeeContractRepository;
import com.enigma.reimbursment.online.repositories.EmployeeRepository;
import com.enigma.reimbursment.online.repositories.ReimbursementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeContractService extends AbstractService<EmployeeContract,String> {

    @Autowired
    EmployeeContractRepository repository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ReimbursementRepository reimbursementRepository;

    @Autowired
    EmployeeContractRepository employeeContractRepository;

   @Autowired
    protected EmployeeContractService(EmployeeContractRepository repository){
       super(repository);
   }

    public EmployeeResponseDashboard responseDashboard() {
        EmployeeResponseDashboard response = new EmployeeResponseDashboard();
        response.setCountEmployeeReimburse(Double.valueOf(reimbursementRepository.getCountEmployeeReimbursement()));
        response.setCountEmployeeActive(response.getCountEmployee());
        response.setCountEmployee(response.getCountEmployee());
        response.setCountEmployeePKWT(response.getCountEmployeePKWT());
        response.setCountEmployeeMale(response.getCountEmployeeMale());
        response.setCountEmployeeProbabition(employeeContractRepository.getCountEmployeeProbabition());
        response.setCountEmployeeFemale(response.getCountEmployeeFemale());
        return response;
    }

}
