package com.enigma.reimbursment.online.models.model.reimbursement;

import java.time.LocalDate;
import java.util.Date;

public class FinanceResponse {

    private LocalDate disbursementDate;

    private Boolean statusSuccess = false;

    private Boolean statusReject = false;

    public Boolean getStatusReject() {
        return statusReject;
    }

    public void setStatusReject(Boolean statusReject) {
        this.statusReject = statusReject;
    }

    public Boolean getStatusSuccess() {
        return statusSuccess;
    }

    public void setStatusSuccess(Boolean statusSuccess) {
        this.statusSuccess = statusSuccess;
    }

    public LocalDate getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(LocalDate disbursementDate) {
        this.disbursementDate = disbursementDate;
    }

    public Boolean getStatusOnFinance() {
        return statusSuccess;
    }

    public void setStatusOnFinance(Boolean statusSuccess) {
        this.statusSuccess = statusSuccess;
    }
}
