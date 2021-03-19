package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.models.response.reimbursement.ReimbursementResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReimbursementRepository extends JpaRepository<Reimbursement,String> {

    @Query(value = "SELECT * FROM reimbursement WHERE id_category = :categoryId",nativeQuery = true)
    List<Reimbursement> filterCategoryById(@Param("categoryId") String categoryId);

    @Query(value = "SELECT * FROM reimbursement WHERE id_category = :categoryId AND id_employee = :employeeId",nativeQuery = true)
    List<ReimbursementResponse> filterCategoryByIdEmployee(@Param("categoryId") String categoryId, @Param("employeeId") String employeeId);

    @Query(value = "SELECT * FROM reimbursement WHERE date_of_claim_submission = :dateOfClaimSubmission",nativeQuery = true)
    List<Reimbursement> filterByDateOfClaim(@Param("dateOfClaimSubmission") String dateOfClaimSubmission);

    //filter by id employee
    @Query(value = "SELECT * FROM reimbursement WHERE id_employee = :employeeId",nativeQuery = true)
    List<Reimbursement> filterByIdEmployee(@Param("employeeId") String employeeId);

    //filter by date,category and id employee
    @Query(value = "SELECT * FROM reimbursement WHERE date_of_claim_submission = :dateOfClaimSubmission AND id_category = :categoryId AND id_employee = :employeeId,", nativeQuery = true)
    List<ReimbursementResponse> filterByDateCategoryAndIdEmployee(@Param("dateOfClaimSubmission") String dateOfClaimSubmission,
                                                                  @Param("categoryId") String categoryId,
                                                                  @Param("employeeId") String employeeId);

}
