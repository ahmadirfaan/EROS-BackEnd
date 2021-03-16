package com.enigma.reimbursment.online.models.request.reimbursements.training;

import com.enigma.reimbursment.online.models.pagination.PageSearch;

public class ReimbursementTrainingSearch extends PageSearch {
    private String trainingStartDate;

    public String getTrainingStartDate() {
        return trainingStartDate;
    }

    public void setTrainingStartDate(String trainingStartDate) {
        this.trainingStartDate = trainingStartDate;
    }
}
