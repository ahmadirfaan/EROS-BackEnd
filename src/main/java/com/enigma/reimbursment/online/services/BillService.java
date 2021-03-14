package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Bill;
import com.enigma.reimbursment.online.repositories.BillRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BillService extends AbstractService<Bill,String>{

    protected BillService(BillRepository repository) {
        super(repository);
    }
}
