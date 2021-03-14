package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.ReimbursementGlasses;
import com.enigma.reimbursment.online.repositories.ReimbursementGlassesRepository;
import com.enigma.reimbursment.online.repositories.ReimbursementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReimbursementGlassesService extends AbstractService<ReimbursementGlasses,String> {


    @Autowired
    protected ReimbursementGlassesService(ReimbursementGlassesRepository repository){
        super(repository);
    }
}