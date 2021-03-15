package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.ReimbursementTravel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface ReimbursementTravelRepository extends JpaRepository<ReimbursementTravel,String> {

    @Query(value = "SELECT * FROM reimburse.reimbursement_travel WHERE id_reimbursement = :reimbursementId",nativeQuery = true)
    ReimbursementTravel getById(@Param("reimbursementId") String reimbursementId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reimbursement_travel SET end_date = :endDate, start_date = :startDate WHERE id_reimbursement = :reimbursementId ",nativeQuery = true)
    ReimbursementTravel edit(@Param("reimbursementId") String reimbursementId, @Param("endDate")String endDate, @Param("startDate") String startDate);

    @Modifying
    @Transactional
    @Query(value = "DELETE reimbursement_travel WHERE id_reimbursement = :reimbursementId",nativeQuery = true)
    Integer deleteReimbursementTravel (@Param("reimbursementId") String reimbursementId);



}
