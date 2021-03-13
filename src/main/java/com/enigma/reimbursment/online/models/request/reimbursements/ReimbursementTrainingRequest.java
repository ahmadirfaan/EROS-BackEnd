package com.enigma.reimbursment.online.models.request.reimbursements;

import com.enigma.reimbursment.online.entities.Reimbursement;

import javax.persistence.Column;
import java.util.Date;

public class ReimbursementTrainingRequest {
    private String reimbursementId;

    public String getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(String reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    private Date trainingStartDate;
    private Date trainingEndDate;

    public Date getTrainingStartDate() {
        return trainingStartDate;
    }

    public void setTrainingStartDate(Date trainingStartDate) {
        this.trainingStartDate = trainingStartDate;
    }

    public Date getTrainingEndDate() {
        return trainingEndDate;
    }

    public void setTrainingEndDate(Date trainingEndDate) {
        this.trainingEndDate = trainingEndDate;
    }


}
