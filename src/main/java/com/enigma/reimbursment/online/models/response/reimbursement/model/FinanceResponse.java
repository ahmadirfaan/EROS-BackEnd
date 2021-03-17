package com.enigma.reimbursment.online.models.response.reimbursement.model;

import java.util.Date;

public class FinanceResponse {

    private Date disbursementDate;

    private Boolean statusOnFinance = false;

    public Date getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(Date disbursementDate) {
        this.disbursementDate = disbursementDate;
    }

    public Boolean getStatusOnFinance() {
        return statusOnFinance;
    }

    public void setStatusOnFinance(Boolean statusOnFinance) {
        this.statusOnFinance = statusOnFinance;
    }
}
