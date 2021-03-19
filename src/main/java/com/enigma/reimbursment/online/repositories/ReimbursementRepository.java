package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReimbursementRepository extends JpaRepository<Reimbursement, String> {

    @Query(value = "SELECT * FROM reimbursement WHERE id_category = :categoryId", nativeQuery = true)
    List<Reimbursement> filterCategoryById(@Param("categoryId") String categoryId);

    @Query(value = "SELECT * FROM reimbursement WHERE id_category = :categoryId AND id_employee = :employeeId", nativeQuery = true)
    List<Reimbursement> filterCategoryByIdEmployee(@Param("categoryId") String categoryId, @Param("employeeId") String employeeId);

    @Query(value = "SELECT * FROM reimbursement WHERE date_of_claim_submission = :dateOfClaimSubmission", nativeQuery = true)
    List<Reimbursement> filterByDateOfClaim(@Param("dateOfClaimSubmission") String dateOfClaimSubmission);

    //filter by id employee
    @Query(value = "SELECT * FROM reimbursement WHERE id_employee = :employeeId", nativeQuery = true)
    List<Reimbursement> filterByIdEmployee(@Param("employeeId") String employeeId);

    //filter by date,category and id employee
    @Query(value = "SELECT * FROM reimbursement WHERE id_category = :categoryId AND id_employee = :employeeId AND date_of_claim_submission BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Reimbursement> filterByDateCategoryAndIdEmployee(@Param("categoryId") String categoryId,
                                                          @Param("employeeId") String employeeId,
                                                          @Param("startDate") String startDate,
                                                          @Param("endDate") String endDate);

    //filter by date(start-end) and id employee
    @Query(value = "SELECT * FROM reimbursement WHERE id_employee = :employeeId AND date_of_claim_submission BETWEEN :startDate AND :endDate",nativeQuery = true)
    List<Reimbursement> filterByDateAndIdEmployee(@Param("employeeId") String employeeId,
                                                  @Param("startDate")String startDate,
                                                  @Param("endDate") String endDate);
}
