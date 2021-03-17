package com.enigma.reimbursment.online.models.response.reimbursement.glasses;

import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.models.response.reimbursement.ReimbursementResponse;

public class ReimbursementGlassesResponse {
    private String id;

    private ReimbursementResponse reimbursementId;

    private Integer borneCost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ReimbursementResponse getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(ReimbursementResponse reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public Integer getBorneCost() {
        return borneCost;
    }

    public void setBorneCost(Integer borneCost) {
        this.borneCost = borneCost;
    }
}
