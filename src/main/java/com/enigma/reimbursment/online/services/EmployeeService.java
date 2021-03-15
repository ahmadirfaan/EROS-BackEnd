package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Employee;
import com.enigma.reimbursment.online.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends AbstractService<Employee,String> {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    protected EmployeeService(EmployeeRepository repository){
        super(repository);
    }

    public Employee checkVerificationEmailToken(String token){
        return employeeRepository.checkVerificationEmailToken(token);
    }

    public Employee findByIdLogin(String idLogin) {
        return employeeRepository.findIdLogin(idLogin);
    }

    public void changeIsVerifiedEmail(String token) {
        employeeRepository.changeIsVerifiedEmail(token);
    }

}