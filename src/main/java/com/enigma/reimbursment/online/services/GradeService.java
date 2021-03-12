package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Grade;
import com.enigma.reimbursment.online.entities.Role;
import com.enigma.reimbursment.online.repositories.GradeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GradeService extends AbstractService<Grade,String>{
    protected GradeService(GradeRepository repository) {
        super(repository);
    }
}
