package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Reimbursement;
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

    public List<Reimbursement> filterByDateOfClaim(String dateOfClaimSubmission) {
        return reimbursementRepository.filterByDateOfClaim(dateOfClaimSubmission);
    }
}
