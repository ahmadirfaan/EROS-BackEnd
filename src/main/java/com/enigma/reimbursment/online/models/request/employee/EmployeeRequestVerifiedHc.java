package com.enigma.reimbursment.online.models.request.employee;

public class EmployeeRequestVerifiedHc {
    private String employeeId;
    private Boolean isVerifiedHc;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Boolean getVerifiedHc() {
        return isVerifiedHc;
    }

    public void setVerifiedHc(Boolean verifiedHc) {
        isVerifiedHc = verifiedHc;
    }
}
