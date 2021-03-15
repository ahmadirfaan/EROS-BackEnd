package com.enigma.reimbursment.online.models.request.reimbursements.reimbursementtravel;

import com.enigma.reimbursment.online.entities.Reimbursement;

import java.time.LocalDate;
import java.util.Date;

public class ReimbursementTravelRequest {

    private String reimbursementId;
    private String startDate;
    private String endDate;

    public String getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(String reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ReimbursementTravelRequest{" +
                "reimbursementId='" + reimbursementId + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
