package com.enigma.reimbursment.online.models.response.reimbursement.travel;

import com.enigma.reimbursment.online.models.response.reimbursement.ReimbursementResponse;

import java.util.Date;

public class ReimbursementTravelResponse {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private ReimbursementResponse reimbursementId;

    private Date startDate;

    private Date endDate;

    public ReimbursementResponse getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(ReimbursementResponse reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
