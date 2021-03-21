package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.models.request.reimbursements.FindCategoryRequestEmployee;
import com.enigma.reimbursment.online.models.response.employee.EmployeeResponseDashboard;
import com.enigma.reimbursment.online.repositories.ReimbursementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReimbursementService extends AbstractService<Reimbursement,String> {

    @Autowired
    ReimbursementRepository reimbursementRepository;

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
        return reimbursementRepository.filterCategoryByIdEmployee(employeeId,categoryId);
    }

    public List<Reimbursement> filterByDateOfClaim(String startDate, String endDate) {
        return reimbursementRepository.filterByDateOfClaim(startDate,endDate);
    }

    public List<Reimbursement> filterByIdEmployee(String employeeId) {
        return reimbursementRepository.filterByIdEmployee(employeeId);
    }

    public List<Reimbursement> filterByDateCategoryAndIdEmployee(String categoryId,String employeeId, String startDate, String endDate){
        return reimbursementRepository.filterByDateCategoryAndIdEmployee(categoryId,employeeId,startDate,endDate);
    }

    public List<Reimbursement> filterByDateAndIdEmployee(String employeeId, String startDate, String endDate) {
        return reimbursementRepository.filterByDateAndIdEmployee(employeeId,startDate,endDate);
    }

    public List<Reimbursement> filterStatusAdminOnHc(Boolean statusReject, Boolean statusOnHc, Boolean statusSuccess, Boolean statusOnFinance){
        return reimbursementRepository.filterStatusAdminOnHc(statusReject, statusOnHc, statusSuccess, statusOnFinance);
    }

    public EmployeeResponseDashboard responseDashboard(){
        EmployeeResponseDashboard response = new EmployeeResponseDashboard();
        response.setCountEmployeeReimburse(reimbursementRepository.getCountEmployeeReimbursement());
        response.setCountEmployeeActive(response.getCountEmployee());
        response.setCountEmployee(response.getCountEmployee());
        return response;


    }
}
