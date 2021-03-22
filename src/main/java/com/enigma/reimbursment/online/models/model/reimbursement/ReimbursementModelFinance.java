package com.enigma.reimbursment.online.models.model.reimbursement;

public class ReimbursementModelFinance {

    private String disbursementDate;

    private Boolean statusSuccess ;

    private Boolean statusReject ;

    public String getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(String disbursementDate) {
        this.disbursementDate = disbursementDate;
    }

    public Boolean getStatusSuccess() {
        return statusSuccess;
    }

    public void setStatusSuccess(Boolean statusSuccess) {
        this.statusSuccess = statusSuccess;
    }

    public Boolean getStatusReject() {
        return statusReject;
    }

    public void setStatusReject(Boolean statusReject) {
        this.statusReject = statusReject;
    }
}
