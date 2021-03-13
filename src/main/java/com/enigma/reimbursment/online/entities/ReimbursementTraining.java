package com.enigma.reimbursment.online.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reimbursement_training")
public class ReimbursementTraining {
    @Id
    @GenericGenerator(name="id",strategy = "uuid2")
    @GeneratedValue(generator = "id",strategy = GenerationType.IDENTITY)
    private String id;
    @OneToOne
    @JoinColumn(name = "id_reimbursement")
    private Reimbursement reimbursementId;
    @Column(name = "training_start_date")
    private Date trainingStartDate;
    @Column(name = "training_end_date")
    private Date trainingEndDate;

    public void setReimbursementId(Reimbursement reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    @OneToOne
    @JoinColumn(name = "id_employee")
    private Employee employeeId;

    public Reimbursement getReimbursementId() {
        return reimbursementId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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
}
