package com.enigma.reimbursment.online.models.request.reimbursements;

import com.enigma.reimbursment.online.entities.Reimbursement;

public class ReimbursementInsuranceRequest {
    private Integer borneCost;

    private String reimbursementId;


    public Integer getBorneCost() {
        return borneCost;
    }

    public void setBorneCost(Integer borneCost) {
        this.borneCost = borneCost;
    }

    public String getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(String reimbursementId) {
        this.reimbursementId = reimbursementId;
    }
}
