package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Employee;
import com.enigma.reimbursment.online.models.response.employee.EmployeeResponseDashboard;
import com.enigma.reimbursment.online.repositories.EmployeeRepository;
import com.enigma.reimbursment.online.repositories.ReimbursementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService extends AbstractService<Employee,String> {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ReimbursementRepository reimbursementRepository;

    @Autowired
    protected EmployeeService(EmployeeRepository repository){
        super(repository);
    }

    public Employee checkVerificationEmailToken(String token){
        return employeeRepository.checkVerificationEmailToken(token);
    }

    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }

    public Employee findByIdLogin(String idLogin) {
        return employeeRepository.findIdLogin(idLogin);
    }

    public void changeIsVerifiedEmail(String token) {
        employeeRepository.changeIsVerifiedEmail(token);
    }

    public EmployeeResponseDashboard employeeDashboard(){
        EmployeeResponseDashboard response = new EmployeeResponseDashboard();
        response.setCountEmployee(employeeRepository.getCountEmployee());
        response.setCountEmployeeActive(employeeRepository.getCountEmployeeActive());
        response.setCountEmployeeReimburse(reimbursementRepository.getCountEmployeeReimbursement());
        return response;
    }

}