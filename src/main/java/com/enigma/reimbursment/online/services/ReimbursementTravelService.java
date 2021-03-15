package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.ReimbursementTravel;
import com.enigma.reimbursment.online.models.request.reimbursements.reimbursementtravel.ReimbursementTravelRequest;
import com.enigma.reimbursment.online.repositories.ReimbursementTravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReimbursementTravelService extends AbstractService<ReimbursementTravel,String>{

    @Autowired
    protected ReimbursementTravelRepository reimbursementTravelRepository;
    protected ReimbursementTravelService(ReimbursementTravelRepository repository) {
        super(repository);
    }

    public ReimbursementTravel getById(String reimbursementId) {
        return reimbursementTravelRepository.getById(reimbursementId);
    }

    public ReimbursementTravel edit(ReimbursementTravelRequest request) {
        ReimbursementTravel reimbursementTravel = reimbursementTravelRepository.edit(request.getReimbursementId(),request.getStartDate(),request.getEndDate());
        return reimbursementTravel;
    }

    public ReimbursementTravel delete(String id) {
        ReimbursementTravel reimbursementTravel = reimbursementTravelRepository.getById(id);
        Integer status = reimbursementTravelRepository.deleteReimbursementTravel(id);
        if(status==0) return null;
        return reimbursementTravel;
    }

}
