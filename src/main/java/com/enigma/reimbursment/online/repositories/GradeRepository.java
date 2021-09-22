package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Grade;
import com.enigma.reimbursment.online.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade,String> {
}
