package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.models.response.reimbursement.ReimbursementResponse;
import com.enigma.reimbursment.online.models.response.employee.EmployeeResponseDashboard;
import com.enigma.reimbursment.online.repositories.EmployeeContractRepository;
import com.enigma.reimbursment.online.repositories.EmployeeRepository;
import com.enigma.reimbursment.online.repositories.ReimbursementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReimbursementService extends AbstractService<Reimbursement, String> {

    @Autowired
    ReimbursementRepository reimbursementRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeContractRepository employeeContractRepository;

    @Autowired
    protected ReimbursementService(ReimbursementRepository repository) {
        super(repository);
    }

    public List<Reimbursement> filterCategoryById(String categoryId) {
        System.out.println(categoryId);
        return reimbursementRepository.filterCategoryById(categoryId);
    }

    public List<Reimbursement> filterCategoryByIdEmployee(String employeeId, String categoryId) {
        System.out.println(categoryId);
        return reimbursementRepository.filterCategoryByIdEmployee(employeeId, categoryId);
    }

    public List<Reimbursement> filterByDateOfClaim(String startDate, String endDate) {
        return reimbursementRepository.filterByDateOfClaim(startDate, endDate);
    }

    public List<Reimbursement> filterByIdEmployee(String employeeId) {
        return reimbursementRepository.filterByIdEmployee(employeeId);
    }

    public List<Reimbursement> filterByDateAndIdEmployee(String employeeId, String startDate, String endDate) {
        return reimbursementRepository.filterByDateAndIdEmployee(employeeId, startDate, endDate);
    }

    public List<Reimbursement> filterByDateCategoryAndIdEmployee(String categoryId, String employeeId, String startDate, String endDate) {
        return reimbursementRepository.filterByDateCategoryAndIdEmployee(categoryId, employeeId, startDate, endDate);
    }

    public List<Reimbursement> filterStatusAdminOnHc(Boolean statusReject, Boolean statusOnHc, Boolean
            statusSuccess, Boolean statusOnFinance) {
        return reimbursementRepository.filterStatusAdminOnHc(statusReject, statusOnHc, statusSuccess, statusOnFinance);
    }

    public EmployeeResponseDashboard responseDashboard() {
        EmployeeResponseDashboard response = new EmployeeResponseDashboard();
        response.setCountEmployeeReimburse(Double.valueOf(reimbursementRepository.getCountEmployeeReimbursement()));
        response.setCountEmployeeActive(response.getCountEmployee());
        response.setCountEmployee(response.getCountEmployee());
        response.setCountEmployeeFemale(employeeRepository.getCountFemaleEmployee());
        response.setCountEmployeeMale(employeeRepository.getCountMaleEmployee());
        response.setCountEmployeePKWT(employeeContractRepository.getCountEmployeePKWT());
        response.setCountEmployeeProbabition(employeeContractRepository.getCountEmployeeProbabition());
        return response;
    }
    //filter status_on_finance_true
    public List<Reimbursement> getStatusFinance() {
        return reimbursementRepository.getStatusFinance();
    }

    //filter status_on_finance_true and byCategoryId
    public List<Reimbursement> getStatusFinanceAndByCategoryId(String categoryId) {
        return reimbursementRepository.getStatusFinanceAndCategoryId(categoryId);
    }


}