package com.enigma.reimbursment.online.models.response.reimbursement;

import com.enigma.reimbursment.online.entities.Reimbursement;

public class ReimbursementInsuranceResponse {

    private String id;
    private Integer borneCost;
    private String reimbursementId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
