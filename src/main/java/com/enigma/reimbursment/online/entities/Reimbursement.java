package com.enigma.reimbursment.online.entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table
public class Reimbursement extends AbstractEntity<String>{
    @Id
    @GenericGenerator(name="id_reimbursement",strategy = "uuid2")
    @GeneratedValue(generator = "id_reimbursement",strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "date_of_claim_submission")
    private Date dateOfClaimSubmission;

    @Column(name = "claim_fee")
//    @Pattern(message = "quantity must be a number",regexp="!/^[0-9]+$/.")
    private Integer claimFee;
    @Column(name = "disbursement_date")
    private Date disbursementDate;
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

    public Date getDateOfClaimSubmission() {
        return dateOfClaimSubmission;
    }

    public void setDateOfClaimSubmission(Date dateOfClaimSumbission) {
        this.dateOfClaimSubmission = dateOfClaimSumbission;
    }

    public Integer getClaimFee() {
        return claimFee;
    }

    public void setClaimFee(Integer claimFee) {
        this.claimFee = claimFee;
    }

    public Date getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(Date disbursmentDate) {
        this.disbursementDate = disbursmentDate;
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


    @Override
    public String toString() {
        return "Reimbursement{" +
                "id='" + id + '\'' +
                ", dateOfClaimSubmission=" + dateOfClaimSubmission +
                ", claimFee=" + claimFee +
                ", disbursementDate=" + disbursementDate +
                ", statusReject=" + statusReject +
                ", statusOnHc=" + statusOnHc +
                ", statusOnFinance=" + statusOnFinance +
                ", statusSuccess=" + statusSuccess +
                ", borneCost=" + borneCost +
                ", employeeId=" + employeeId +
                ", categoryId=" + categoryId +
                '}';
    }
}
