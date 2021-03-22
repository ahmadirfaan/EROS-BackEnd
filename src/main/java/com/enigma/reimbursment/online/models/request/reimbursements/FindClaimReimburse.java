package com.enigma.reimbursment.online.models.request.reimbursements;

import com.enigma.reimbursment.online.entities.Category;
import com.enigma.reimbursment.online.entities.Employee;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class FindClaimReimburse {

    private String dateOfClaimSubmission;

    private Integer claimFee;

    private String employeeId;

    private String categoryId;

    private String startDate;

    private String endDate;

    public String getDateOfClaimSubmission() {
        return dateOfClaimSubmission;
    }

    public void setDateOfClaimSubmission(String dateOfClaimSubmission) {
        this.dateOfClaimSubmission = dateOfClaimSubmission;
    }

    public Integer getClaimFee() {
        return claimFee;
    }

    public void setClaimFee(Integer claimFee) {
        this.claimFee = claimFee;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "FindClaimReimburse{" +
                "dateOfClaimSubmission='" + dateOfClaimSubmission + '\'' +
                ", claimFee=" + claimFee +
                ", employeeId='" + employeeId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
