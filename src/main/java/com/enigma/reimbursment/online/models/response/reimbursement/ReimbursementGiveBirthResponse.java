package com.enigma.reimbursment.online.models.response.reimbursement;

import com.enigma.reimbursment.online.entities.Reimbursement;

public class ReimbursementGiveBirthResponse {

    private  String id;

    private String reimbursementId;

    private Integer laborCost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(String reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public Integer getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(Integer laborCost) {
        this.laborCost = laborCost;
    }
}
