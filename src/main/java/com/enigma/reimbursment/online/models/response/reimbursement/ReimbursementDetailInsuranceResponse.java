package com.enigma.reimbursment.online.models.response.reimbursement;

import com.enigma.reimbursment.online.entities.ReimbursementInsurance;

public class ReimbursementDetailInsuranceResponse {

    private String id;
    private String typeOfInsurance;

    private String reimbursementId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeOfInsurance() {
        return typeOfInsurance;
    }

    public void setTypeOfInsurance(String typeOfInsurance) {
        this.typeOfInsurance = typeOfInsurance;
    }

    public String getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(String reimbursementId) {
        this.reimbursementId = reimbursementId;
    }
}
