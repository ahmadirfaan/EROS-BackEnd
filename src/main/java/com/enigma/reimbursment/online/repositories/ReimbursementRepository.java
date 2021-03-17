package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReimbursementRepository extends JpaRepository<Reimbursement,String> {

    @Query(value = "SELECT * FROM reimburse WHERE id_category = :categoryId",nativeQuery = true)
    List<Reimbursement> searchCategoryById(@Param("categoryId") String categoryId);

    @Query(value = "SELECT * FROM reimburse WHERE date_of_claim_submission = :dateOfClaimSubmission",nativeQuery = true)
    List<Reimbursement> searchByDateoFClaim(@Param("dateOfClaimSubmission") String dateOfClaimSubmission);

}
