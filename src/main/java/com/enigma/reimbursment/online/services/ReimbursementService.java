package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.models.request.reimbursements.FindCategoryRequestEmployee;
import com.enigma.reimbursment.online.models.response.reimbursement.ReimbursementResponse;
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

    public List<ReimbursementResponse> filterCategoryByIdEmployee(String employeeId, String categoryId) {
        System.out.println(categoryId);
        return reimbursementRepository.filterCategoryByIdEmployee(employeeId,categoryId);
    }

    public List<Reimbursement> filterByDateOfClaim(String dateOfClaimSubmission) {
        return reimbursementRepository.filterByDateOfClaim(dateOfClaimSubmission);
    }

    public List<Reimbursement> filterByIdEmployee(String employeeId) {
        return reimbursementRepository.filterByIdEmployee(employeeId);
    }

    public List<ReimbursementResponse> filterByDateCategoryAndIdEmployee(String dateOfClaimSubmission, String categoryId, String employeeId){
        return reimbursementRepository.filterByDateCategoryAndIdEmployee(dateOfClaimSubmission, categoryId, employeeId);
    }
}
