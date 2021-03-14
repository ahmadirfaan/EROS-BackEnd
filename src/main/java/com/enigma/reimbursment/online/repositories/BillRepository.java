package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,String> {
}
