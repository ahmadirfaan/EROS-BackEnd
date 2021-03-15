package com.enigma.reimbursment.online.models.response.employee;

import com.enigma.reimbursment.online.models.response.login.LoginResponse;

import java.time.LocalDate;

public class EmployeeResponse {

    private String id;

    private LoginResponse idLogin;

    private String fullname;

    private String gender;

    private String nik;

    private String nip;

    private String emergencyNumber;

    private String employeeStatus;

    private String employeeType;

    private String npwp;

    private String grade;

    private String religion;

    private String bloodType;

    private String phoneNumber;

    private String accountNumber;

    private String accountName;

    private String placeOfBirth;

    private LocalDate dateOfBirth;

    private String maritalStatus;

    private Integer numberOfChildren;

    private LocalDate joinDate;

    private String biologicalMothersName;

    private String wifeName;

    private String husbandName;

    private String emailVerificationToken;

    private Boolean isVerifiedEmail;

    private String ktpAddress;

    private String npwpAddress;

    private String residenceAddress;

    private String postalCodeOfIdCard;


    /* Getter & Setter */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LoginResponse getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(LoginResponse idLogin) {
        this.idLogin = idLogin;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(Integer numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getBiologicalMothersName() {
        return biologicalMothersName;
    }

    public void setBiologicalMothersName(String biologicalMothersName) {
        this.biologicalMothersName = biologicalMothersName;
    }

    public String getWifeName() {
        return wifeName;
    }

    public void setWifeName(String wifeName) {
        this.wifeName = wifeName;
    }

    public String getHusbandName() {
        return husbandName;
    }

    public void setHusbandName(String husbandName) {
        this.husbandName = husbandName;
    }

    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    public Boolean getVerifiedEmail() {
        return isVerifiedEmail;
    }

    public void setVerifiedEmail(Boolean verifiedEmail) {
        isVerifiedEmail = verifiedEmail;
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
        return "EmployeeResponse{" +
                "id='" + id + '\'' +
                ", idLogin=" + idLogin +
                ", fullname='" + fullname + '\'' +
                ", gender='" + gender + '\'' +
                ", nik='" + nik + '\'' +
                ", nip='" + nip + '\'' +
                ", emergencyNumber='" + emergencyNumber + '\'' +
                ", employeeStatus='" + employeeStatus + '\'' +
                ", employeeType='" + employeeType + '\'' +
                ", npwp='" + npwp + '\'' +
                ", grade='" + grade + '\'' +
                ", religion='" + religion + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", numberOfChildren=" + numberOfChildren +
                ", joinDate=" + joinDate +
                ", biologicalMothersName='" + biologicalMothersName + '\'' +
                ", wifeName='" + wifeName + '\'' +
                ", husbandName='" + husbandName + '\'' +
                ", emailVerificationToken='" + emailVerificationToken + '\'' +
                ", isVerifiedEmail=" + isVerifiedEmail +
                ", ktpAddress='" + ktpAddress + '\'' +
                ", npwpAddress='" + npwpAddress + '\'' +
                ", residenceAddress='" + residenceAddress + '\'' +
                ", postalCodeOfIdCard='" + postalCodeOfIdCard + '\'' +
                '}';
    }
}
