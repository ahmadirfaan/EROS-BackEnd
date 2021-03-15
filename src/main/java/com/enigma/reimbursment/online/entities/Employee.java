package com.enigma.reimbursment.online.entities;

import com.enigma.reimbursment.online.enums.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "employee")
@Entity
public class Employee extends AbstractEntity <String>{

    @Id
    @GenericGenerator(name="id",strategy = "uuid2")
    @GeneratedValue(generator = "id",strategy = GenerationType.IDENTITY)
    private String id;

    @OneToOne
    @JoinColumn(name = "id_login")
    private Login login;

    @Column
    private String fullname;

    @Column
    private Gender gender;

    @Column
    private String nik;

    @Column
    private String nip;

    @Column(name = "emergency_number")
    private String emergencyNumber;

    @Column(name = "employee_status")
    private EmployeeStatus employeeStatus;

    @Column(name = "employee_type")
    private EmployeeType employeeType;

    @Column
    private String npwp;

    @Column
    private String grade;

    @Column
    private Religion religion;

    @Column(name = "blood_type")
    private BloodType  bloodType;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "marital_status")
    private MaritalStatus maritalStatus;

    @Column(name = "number_of_children")
    private Integer numberOfChildren;

    @Column(name = "join_date")
    private LocalDate joinDate;

    @Column(name = "biological_mother_name")
    private String biologicalMothersName;

    @Column(name = "wife_name")
    private String wifeName;

    @Column(name = "husband_name")
    private String husbandName;

    @Column(name = "email_verification_token")
    private String emailVerificationToken;

    @Column(name = "is_verified_email")
    private Boolean isVerifiedEmail = false;

    @Column(name = "ktp_address")
    private String ktpAddress;

    @Column(name = "npwp_address")
    private String npwpAddress;

    @Column(name = "residence_address")
    private String residenceAddress;

    @Column(name = "postal_code_of_id_card")
    private String postalCodeOfIdCard;


    /* Getter & Setter */

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
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


    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setNumberOfChildren(Integer numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public Boolean getIsVerifiedEmail() {
        return isVerifiedEmail;
    }

    public void setIsVerifiedEmail(Boolean verified) {
        isVerifiedEmail = verified;
    }

    public Login getIdLogin() {
        return login;
    }

    public void setIdLogin(Login login) {
        this.login = login;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
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

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
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

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
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


    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
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
                '}';
    }
}