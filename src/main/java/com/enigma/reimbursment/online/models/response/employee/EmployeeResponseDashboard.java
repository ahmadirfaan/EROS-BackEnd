package com.enigma.reimbursment.online.models.response.employee;

public class EmployeeResponseDashboard {

    private Integer countEmployee;

    private Integer countEmployeeActive;

    private Integer countEmployeeReimburse;

    public Integer getCountEmployeeReimburse() {
        return countEmployeeReimburse;
    }

    public void setCountEmployeeReimburse(Integer countEmployeeReimburse) {
        this.countEmployeeReimburse = countEmployeeReimburse;
    }

    public Integer getCountEmployee() {
        return countEmployee;
    }

    public void setCountEmployee(Integer countEmployee) {
        this.countEmployee = countEmployee;
    }

    public Integer getCountEmployeeActive() {
        return countEmployeeActive;
    }

    public void setCountEmployeeActive(Integer countEmployeeActive) {
        this.countEmployeeActive = countEmployeeActive;
    }
}
