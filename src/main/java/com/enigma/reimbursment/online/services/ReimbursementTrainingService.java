package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.ReimbursementTraining;
import com.enigma.reimbursment.online.repositories.ReimbursementTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReimbursementTrainingService extends AbstractService<ReimbursementTraining,String> {

    @Autowired
    protected ReimbursementTrainingService(ReimbursementTrainingRepository repository) {
        super(repository);
    }
}
