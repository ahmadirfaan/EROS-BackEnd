package com.enigma.reimbursment.online.models.response.reimbursement.reimbursementtravel;

import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.models.response.reimbursement.ReimbursementResponse;

import java.time.LocalDate;
import java.util.Date;

public class ReimbursementTravelResponse {

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
