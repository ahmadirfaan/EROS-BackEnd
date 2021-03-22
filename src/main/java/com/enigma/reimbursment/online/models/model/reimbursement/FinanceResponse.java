package com.enigma.reimbursment.online.models.model.reimbursement;

import java.time.LocalDate;
import java.util.Date;

public class FinanceResponse {

    private LocalDate disbursementDate;

    private Boolean statusOnFinance = false;

    public LocalDate getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(LocalDate disbursementDate) {
        this.disbursementDate = disbursementDate;
    }

    public Boolean getStatusOnFinance() {
        return statusOnFinance;
    }

    public void setStatusOnFinance(Boolean statusOnFinance) {
        this.statusOnFinance = statusOnFinance;
    }
}
