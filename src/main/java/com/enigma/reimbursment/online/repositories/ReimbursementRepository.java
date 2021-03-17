package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReimbursementRepository extends JpaRepository<Reimbursement,String> {

    @Query(value = "SELECT * FROM reimbursement WHERE id_category = :categoryId",nativeQuery = true)
    List<Reimbursement> filterCategoryById(@Param("categoryId") String categoryId);

    @Query(value = "SELECT * FROM reimbursement WHERE date_of_claim_submission = :dateOfClaimSubmission",nativeQuery = true)
    List<Reimbursement> filterByDateOfClaim(@Param("dateOfClaimSubmission") String dateOfClaimSubmission);

}
