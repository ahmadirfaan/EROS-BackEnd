package com.enigma.reimbursment.online.models.model.reimbursement;

import java.util.Date;

public class ReimbursementModelFinance {

    private String disbursementDate;

    private Boolean statusOnFinance = false;



    public String getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(String disbursementDate) {
        this.disbursementDate = disbursementDate;
    }

    public Boolean getStatusOnFinance() {
        return statusOnFinance;
    }

    public void setStatusOnFinance(Boolean statusOnFinance) {
        this.statusOnFinance = statusOnFinance;
    }

    @Override
    public String toString() {
        return "ReimbursementModelFinance{" +
                "disbursementDate=" + disbursementDate +
                ", statusOnFinance=" + statusOnFinance +
                '}';
    }
}
