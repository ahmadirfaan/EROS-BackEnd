package com.enigma.reimbursment.online.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "reimbursement_give_birth")
public class ReimbursementGiveBirth {
    @Id
    @GenericGenerator(name="id",strategy = "uuid2")
    @GeneratedValue(generator = "id",strategy = GenerationType.IDENTITY)
    private String id;
    @OneToOne
    @JoinColumn(name = "id_reimbursement")
    private Reimbursement reimbursementId;
    @Column(name = "labor_cost")
    private Integer laborCost;

    public Reimbursement getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(Reimbursement reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public Integer getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(Integer laborCost) {
        this.laborCost = laborCost;
    }
}
