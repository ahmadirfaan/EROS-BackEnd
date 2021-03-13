package com.enigma.reimbursment.online.entities;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reimbursement_travel")
public class ReimbursementTravel {

    @Id
    @GenericGenerator(name="id",strategy = "uuid2")
    @GeneratedValue(generator = "id",strategy = GenerationType.IDENTITY)
    private String id;
    @OneToOne
    @JoinColumn(name = "id_reimbursement")
    private Reimbursement reimbursementId;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

    public Reimbursement getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(Reimbursement reimbursementId) {
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
