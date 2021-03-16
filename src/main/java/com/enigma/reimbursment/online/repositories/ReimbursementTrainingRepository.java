package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.ReimbursementTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReimbursementTrainingRepository extends JpaRepository<ReimbursementTraining,String> {

}
