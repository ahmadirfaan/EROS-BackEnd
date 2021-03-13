package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.repositories.ReimbursementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReimbursementService extends AbstractService<Reimbursement,String> {

    @Autowired
    protected ReimbursementService(ReimbursementRepository repository) {
        super(repository);
    }
}
