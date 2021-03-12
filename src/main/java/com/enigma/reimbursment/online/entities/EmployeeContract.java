package com.enigma.reimbursment.online.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "employee_contract")
@Entity
public class EmployeeContract extends AbstractEntity <Integer>{

    @Id
    @GenericGenerator(name="id",strategy = "uuid2")
    @GeneratedValue(generator = "id",strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "type_contract")
    private String typeContract;

    @Column(name = "benefit_registration_status")
    private String benefitRegistrationStatus;

    @Column(name = "start_date_contract")
    private LocalDate startDateContract;

    @Column(name = "end_date_contract")
    private LocalDate endDateContract;

    @Column(name = "is_ended_contract")
    private Boolean isEndedContract;

    @Column(name = "date_of_acceptance_permanent_employee")
    private LocalDate dateOfAcceptancePermanentEmployee;

    @Column(name = "date_of_resignation")
    private LocalDate dateOfResignation;

    @Column(name = "placement")
    private String placement;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
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

    public LocalDate getStartDateContract() {
        return startDateContract;
    }

    public void setStartDateContract(LocalDate startDateContract) {
        this.startDateContract = startDateContract;
    }

    public LocalDate getEndDateContract() {
        return endDateContract;
    }

    public void setEndDateContract(LocalDate endDateContract) {
        this.endDateContract = endDateContract;
    }

    public Boolean getEndedContract() {
        return isEndedContract;
    }

    public void setEndedContract(Boolean endedContract) {
        isEndedContract = endedContract;
    }

    public LocalDate getDateOfAcceptancePermanentEmployee() {
        return dateOfAcceptancePermanentEmployee;
    }

    public void setDateOfAcceptancePermanentEmployee(LocalDate dateOfAcceptancePermanentEmployee) {
        this.dateOfAcceptancePermanentEmployee = dateOfAcceptancePermanentEmployee;
    }

    public LocalDate getDateOfResignation() {
        return dateOfResignation;
    }

    public void setDateOfResignation(LocalDate dateOfResignation) {
        this.dateOfResignation = dateOfResignation;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }
}
