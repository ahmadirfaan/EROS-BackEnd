package com.enigma.reimbursment.online.entities;

import javax.persistence.*;

@Table(name = "employee_address")
@Entity
public class EmployeeAddress {

    @Id
    @OneToOne
    @JoinColumn(name = "employee_id")
    private String employeeId;

    @Column(name = "ktp_address")
    private String ktpAddress;

    @Column(name = "npwp_address")
    private String npwpAddress;

    @Column(name = "residence_address")
    private String residenceAddress;

    @Column(name = "postal_code_of_id_card")
    private String postalCodeOfIdCard;


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getKtpAddress() {
        return ktpAddress;
    }

    public void setKtpAddress(String ktpAddress) {
        this.ktpAddress = ktpAddress;
    }

    public String getNpwpAddress() {
        return npwpAddress;
    }

    public void setNpwpAddress(String npwpAddress) {
        this.npwpAddress = npwpAddress;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getPostalCodeOfIdCard() {
        return postalCodeOfIdCard;
    }

    public void setPostalCodeOfIdCard(String postalCodeOfIdCard) {
        this.postalCodeOfIdCard = postalCodeOfIdCard;
    }


    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "employeeId='" + employeeId + '\'' +
                ", ktpAddress='" + ktpAddress + '\'' +
                ", npwpAddress='" + npwpAddress + '\'' +
                ", residenceAddress='" + residenceAddress + '\'' +
                ", postalCodeOfIdCard='" + postalCodeOfIdCard + '\'' +
                '}';
    }
}
