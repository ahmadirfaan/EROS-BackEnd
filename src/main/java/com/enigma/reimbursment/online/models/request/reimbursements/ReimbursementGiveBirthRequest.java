package com.enigma.reimbursment.online.models.request.reimbursements;

import com.enigma.reimbursment.online.entities.Reimbursement;

import javax.persistence.Column;

public class ReimbursementGiveBirthRequest {

    private String reimbursementId;

    public String getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(String reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    private Integer laborCost;

    public Integer getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(Integer laborCost) {
        this.laborCost = laborCost;
    }
}
