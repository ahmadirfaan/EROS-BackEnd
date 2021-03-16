package com.enigma.reimbursment.online.models.request.reimbursements.training;

public class ReimbursementTrainingRequest {
    private String reimbursementId;

    public String getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(String reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    private String trainingStartDate;
    private String trainingEndDate;

    public String getTrainingStartDate() {
        return trainingStartDate;
    }

    public void setTrainingStartDate(String trainingStartDate) {
        this.trainingStartDate = trainingStartDate;
    }

    public String getTrainingEndDate() {
        return trainingEndDate;
    }

    public void setTrainingEndDate(String trainingEndDate) {
        this.trainingEndDate = trainingEndDate;
    }

    @Override
    public String toString() {
        return "ReimbursementTrainingRequest{" +
                "reimbursementId='" + reimbursementId + '\'' +
                ", trainingStartDate='" + trainingStartDate + '\'' +
                ", trainingEndDate='" + trainingEndDate + '\'' +
                '}';
    }
}
