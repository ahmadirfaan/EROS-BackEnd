package com.enigma.reimbursment.online.models.model.reimbursement;

import javax.persistence.Column;

public class ReimbursementModelHc {

    private Boolean statusReject = false;

    private Boolean statusOnHc = false;

    private Boolean statusSuccess = false;

    public Boolean getStatusReject() {
        return statusReject;
    }

    public void setStatusReject(Boolean statusReject) {
        this.statusReject = statusReject;
    }

    public Boolean getStatusOnHc() {
        return statusOnHc;
    }

    public void setStatusOnHc(Boolean statusOnHc) {
        this.statusOnHc = statusOnHc;

    }

    public Boolean getStatusSuccess() {
        return statusSuccess;
    }

    public void setStatusSuccess(Boolean statusSuccess) {
        this.statusSuccess = statusSuccess;
    }

    @Override
    public String toString() {
        return "ReimbursementModelHc{" +
                "statusReject=" + statusReject +
                ", statusOnHc=" + statusOnHc +
                ", statusSuccess=" + statusSuccess +
                '}';
    }
}
