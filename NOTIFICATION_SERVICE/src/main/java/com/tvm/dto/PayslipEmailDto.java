package com.tvm.dto;

public class PayslipEmailDto {
    private String employeeEmail;
    private String employeeName;
    private String month;
    private String payslipUrl;

    public PayslipEmailDto() {
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {

        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeName() {

        return employeeName;
    }

    public void setEmployeeName(String employeeName) {

        this.employeeName = employeeName;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getPayslipUrl() {
        return payslipUrl;
    }

    public void setPayslipUrl(String payslipUrl) {
        this.payslipUrl = payslipUrl;
    }

    public String getEmail() {
        return this.employeeEmail;
    }
}


