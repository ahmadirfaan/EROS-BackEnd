package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.ReimbursementTravel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReimbursementTravelRepository extends JpaRepository<ReimbursementTravel,String> {
}
