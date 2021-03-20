package com.enigma.reimbursment.online.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "bill")
public class Bill extends AbstractEntity<String>{

    @Id
    @GenericGenerator(name = "id", strategy = "uuid2")
    @GeneratedValue(generator = "id", strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "bill_image")
    private String billImage;

    //tambahan
    @Column(name = "url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Bill() {
    }

    public Bill(String billImage, String url) {
        this.billImage = billImage;
        this.url = url;
    }

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

    public String getBillImage() {
        return billImage;
    }

    public void setBillImage(String billImage) {
        this.billImage = billImage;
    }

    public Reimbursement getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(Reimbursement reimbursementBillId) {
        this.reimbursementId = reimbursementBillId;
    }
}
