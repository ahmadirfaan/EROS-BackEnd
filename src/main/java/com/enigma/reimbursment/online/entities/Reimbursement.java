package com.enigma.reimbursment.online.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reimbursement")
public class Reimbursement extends AbstractEntity<String>{
    @Id
    @GenericGenerator(name="id_reimbursement",strategy = "uuid2")
    @GeneratedValue(generator = "id_reimbursement",strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "date_of_claim_sumbission")
    private Date dateOfClaimSumbission;
    @Column(name = "claim_fee")
    private Integer claimFee;
    @Column(name = "disbursment_date")
    private Date disbursmentDate;
    @Column(name = "status_reject")
    private Boolean statusReject;
    @Column(name = "status_on_hc")
    private Boolean statusOnHc;
    @Column(name = "status_on_finance")
    private Boolean statusOnFinance;
    @Column(name = "status_success")
    private Boolean statusSuccess;
    @Column(name = "borne_cost")
    private Integer borneCost;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employeeId;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category categoryId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Date getDateOfClaimSumbission() {
        return dateOfClaimSumbission;
    }

    public void setDateOfClaimSumbission(Date dateOfClaimSumbission) {
        this.dateOfClaimSumbission = dateOfClaimSumbission;
    }

    public Integer getClaimFee() {
        return claimFee;
    }

    public void setClaimFee(Integer claimFee) {
        this.claimFee = claimFee;
    }

    public Date getDisbursmentDate() {
        return disbursmentDate;
    }

    public void setDisbursmentDate(Date disbursmentDate) {
        this.disbursmentDate = disbursmentDate;
    }

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

    public Boolean getStatusOnFinance() {
        return statusOnFinance;
    }

    public void setStatusOnFinance(Boolean statusOnFinance) {
        this.statusOnFinance = statusOnFinance;
    }

    public Boolean getStatusSuccess() {
        return statusSuccess;
    }

    public void setStatusSuccess(Boolean statusSuccess) {
        this.statusSuccess = statusSuccess;
    }

    public Integer getBorneCost() {
        return borneCost;
    }

    public void setBorneCost(Integer borneCost) {
        this.borneCost = borneCost;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }


}
