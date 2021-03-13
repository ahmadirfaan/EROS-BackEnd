package com.enigma.reimbursment.online.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "reimbursement_insurance")
public class ReimbursementInsurance extends AbstractEntity <String> {
    @Id
    @GenericGenerator(name = "id_insurance", strategy = "uuid2")
    @GeneratedValue(generator = "id_insurance", strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "borne_cost")
    private Integer borneCost;

    @OneToOne
    @JoinColumn(name = "id_reimbursement")
    private Reimbursement reimbursementId;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public Integer getBorneCost() {
        return borneCost;
    }

    public void setBorneCost(Integer borneCost) {
        this.borneCost = borneCost;
    }

    public Reimbursement getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(Reimbursement reimbursementId) {
        this.reimbursementId = reimbursementId;
    }
}
