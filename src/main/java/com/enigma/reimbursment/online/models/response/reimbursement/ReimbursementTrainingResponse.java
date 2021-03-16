package com.enigma.reimbursment.online.models.response.reimbursement;

import com.enigma.reimbursment.online.entities.Employee;
import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.models.response.employee.EmployeeResponse;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

public class ReimbursementTrainingResponse {
    private String id;
    private ReimbursementResponse reimbursementId;
    private Date trainingStartDate;
    private Date trainingEndDate;

    public ReimbursementResponse getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(ReimbursementResponse reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public Date getTrainingStartDate() {
        return trainingStartDate;
    }

    public void setTrainingStartDate(Date trainingStartDate) {
        this.trainingStartDate = trainingStartDate;
    }

    public Date getTrainingEndDate() {
        return trainingEndDate;
    }

    public void setTrainingEndDate(Date trainingEndDate) {
        this.trainingEndDate = trainingEndDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
