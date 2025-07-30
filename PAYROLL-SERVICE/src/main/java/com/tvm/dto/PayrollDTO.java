package com.tvm.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayrollDTO {
    private Long employeeId;
    private int month;
    private int year;
    private double basicSalary;
    private double bonus;
    private double deductions;
    private double netPay;
}
