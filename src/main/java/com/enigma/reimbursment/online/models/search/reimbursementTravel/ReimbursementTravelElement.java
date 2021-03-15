package com.enigma.reimbursment.online.models.search.reimbursementTravel;

import com.enigma.reimbursment.online.entities.Reimbursement;

import javax.persistence.Column;
import java.util.Date;

public class ReimbursementTravelElement {
    private String reimbursementId;
    private Date startDate;
    private Date endDate;

    public String getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(String reimbursementId) {
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
