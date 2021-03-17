package com.enigma.reimbursment.online.models.request.reimbursements.glasses;

import com.enigma.reimbursment.online.entities.Reimbursement;

public class ReimbursementGlassesRequest {

    private Integer borneCost;

    private String reimbursementId;

    public String getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(String reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public Integer getBorneCost() {
        return borneCost;
    }

    public void setBorneCost(Integer borneCost) {
        this.borneCost = borneCost;
    }


}
