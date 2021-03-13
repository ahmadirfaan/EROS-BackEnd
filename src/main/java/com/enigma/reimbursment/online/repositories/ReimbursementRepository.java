package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReimbursementRepository extends JpaRepository<Reimbursement,String> {
}
