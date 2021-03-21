package com.enigma.reimbursment.online.models.response.employee;


import java.util.Date;

public class EmployeeContractResponse {

    private String id;

    private EmployeeResponse employeeId;

    private String typeContract;

    private String benefitRegistrationStatus;

    private Date startDateContract;

    private Date endDateContract;

    private Boolean isEndedContract = false;

    private Date dateOfAcceptancePermanentEmployee;

    private Date dateOfResignation;

    private String placement;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EmployeeResponse getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(EmployeeResponse employeeId) {
        this.employeeId = employeeId;
    }

    public String getTypeContract() {
        return typeContract;
    }

    public void setTypeContract(String typeContract) {
        this.typeContract = typeContract;
    }

    public String getBenefitRegistrationStatus() {
        return benefitRegistrationStatus;
    }

    public void setBenefitRegistrationStatus(String benefitRegistrationStatus) {
        this.benefitRegistrationStatus = benefitRegistrationStatus;
    }

    public Date getStartDateContract() {
        return startDateContract;
    }

    public void setStartDateContract(Date startDateContract) {
        this.startDateContract = startDateContract;
    }

    public Date getEndDateContract() {
        return endDateContract;
    }

    public void setEndDateContract(Date endDateContract) {
        this.endDateContract = endDateContract;
    }

    public Boolean getEndedContract() {
        return isEndedContract;
    }

    public void setEndedContract(Boolean endedContract) {
        isEndedContract = endedContract;
    }

    public Date getDateOfAcceptancePermanentEmployee() {
        return dateOfAcceptancePermanentEmployee;
    }

    public void setDateOfAcceptancePermanentEmployee(Date dateOfAcceptancePermanentEmployee) {
        this.dateOfAcceptancePermanentEmployee = dateOfAcceptancePermanentEmployee;
    }

    public Date getDateOfResignation() {
        return dateOfResignation;
    }

    public void setDateOfResignation(Date dateOfResignation) {
        this.dateOfResignation = dateOfResignation;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }


}
