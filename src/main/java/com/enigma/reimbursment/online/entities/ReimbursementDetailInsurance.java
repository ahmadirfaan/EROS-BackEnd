package com.enigma.reimbursment.online.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "reimbursement_detail_insurance")
public class ReimbursementDetailInsurance {

    @Id
    @GenericGenerator(name="id",strategy = "uuid2")
    @GeneratedValue(generator = "id",strategy = GenerationType.IDENTITY)
    private String id;
    @OneToOne
    @JoinColumn(name = "id_reimbursement")
    private Reimbursement reimbursementId;

    @Column(name = "type_of_insurance")
    private String typeOfInsurance;

    public Reimbursement getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(Reimbursement reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public String getTypeOfInsurance() {
        return typeOfInsurance;
    }

    public void setTypeOfInsurance(String typeOfInsurance) {
        this.typeOfInsurance = typeOfInsurance;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ReimbursementDetailInsurance{" +
                "id='" + id + '\'' +
                ", reimbursementId=" + reimbursementId +
                ", typeOfInsurance='" + typeOfInsurance + '\'' +
                '}';
    }
}
