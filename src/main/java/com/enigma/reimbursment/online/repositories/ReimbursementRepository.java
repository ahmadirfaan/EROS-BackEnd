package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.models.response.reimbursement.ReimbursementResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReimbursementRepository extends JpaRepository<Reimbursement, String> {

    @Query(value = "SELECT * FROM reimbursement WHERE id_category = :categoryId", nativeQuery = true)
    List<Reimbursement> filterCategoryById(@Param("categoryId") String categoryId);


    @Query(value = "SELECT * FROM reimbursement WHERE id_category = :categoryId AND id_employee = :employeeId", nativeQuery = true)
    List<Reimbursement> filterCategoryByIdEmployee(@Param("categoryId") String categoryId, @Param("employeeId") String employeeId);


    //filter by date
    @Query(value = "SELECT * FROM reimbursement WHERE date_of_claim_submission  BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Reimbursement> filterByDateOfClaim(@Param("startDate") String startDate,
                                            @Param("endDate") String endDate);

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
    @Query(value = "SELECT * FROM reimbursement WHERE id_employee = :employeeId AND date_of_claim_submission BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Reimbursement> filterByDateAndIdEmployee(@Param("employeeId") String employeeId,
                                                  @Param("startDate") String startDate,
                                                  @Param("endDate") String endDate);

    //filter status on adminHc(status_onFinance,on hc,reject,success)
    @Query(value = "SELECT * FROM reimbursement WHERE status_reject = :statusReject AND status_on_hc = :statusOnHc AND status_success = :statusSuccess AND status_on_finance = :statusOnFinance", nativeQuery = true)
    List<Reimbursement> filterStatusAdminOnHc(@Param("statusReject") Boolean statusReject,
                                              @Param("statusOnHc") Boolean statusOnHc,
                                              @Param("statusSuccess") Boolean statusSuccess,
                                              @Param("statusOnFinance") Boolean statusOnFinance);

    @Query(value = "SELECT COUNT(id) FROM reimbursement", nativeQuery = true)
    Integer getCountEmployeeReimbursement();


    //filter status_on_finance_true
    @Query(value = "SELECT * FROM reimbursement WHERE status_on_finance = true", nativeQuery = true)
    List<Reimbursement> getStatusFinance();

    //filter status_on_finance_true and byCategoryId
    @Query(value = "SELECT * FROM reimbursement WHERE status_on_finance = true AND id_category = :categoryId", nativeQuery = true)
    List<Reimbursement> getStatusFinanceAndCategoryId(@Param("categoryId") String categoryId);

}
