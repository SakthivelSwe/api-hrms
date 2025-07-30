package com.tvm.service;

import com.tvm.entity.Payroll;
import com.tvm.feign.EmployeeClient;
import com.tvm.repository.PayrollRepository;
import com.tvm.util.PayslipGenerator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PayrollService {

    private final PayrollRepository payrollRepository;
    private final EmployeeClient employeeClient;

//    @Transactional
//    public Payroll processPayroll(Long employeeId, int month, int year) {
//        boolean alreadyExists = payrollRepository.existsByEmployeeIdAndMonthAndYear(employeeId, month, year);
//        if (alreadyExists) {
//            throw new RuntimeException("Payroll already processed for this employee/month/year");
//        }
//
//        // Fetch basic salary from employee-service
//        double basicSalary = employeeClient.getBasicSalary(employeeId);
//
//        // These values can later be made dynamic (from leave-service, etc.)
//        double bonus = 2000.0;
//        double deductions = 1500.0;
//
//        double netPay = basicSalary + bonus - deductions;
//
//        Payroll payroll = Payroll.builder()
//                .employeeId(employeeId)
//                .month(month)
//                .year(year)
//                .basicSalary(basicSalary)
//                .bonus(bonus)
//                .deductions(deductions)
//                .netPay(netPay)
//                .generatedDate(LocalDate.now())
//                .build();
//
//        return payrollRepository.save(payroll);
//    }
@Transactional
public Payroll processPayroll(Long employeeId, int month, int year) {
    boolean alreadyExists = payrollRepository.existsByEmployeeIdAndMonthAndYear(employeeId, month, year);
    if (alreadyExists) {
        throw new RuntimeException("Payroll already processed for this employee/month/year");
    }

    // Step 1: Get salary
    double basicSalary = employeeClient.getBasicSalary(employeeId);

    // Step 2: Apply business logic
    double bonus = 2000.0;
    double deductions = 1500.0;
    double netPay = basicSalary + bonus - deductions;

    // Step 3: Build payroll
    Payroll payroll = Payroll.builder()
            .employeeId(employeeId)
            .month(month)
            .year(year)
            .basicSalary(basicSalary)
            .bonus(bonus)
            .deductions(deductions)
            .netPay(netPay)
            .generatedDate(LocalDate.now())
            .build();

    // Step 4: Save to DB
    Payroll savedPayroll = payrollRepository.save(payroll);

    // Step 5: Generate PDF
    try {
        ByteArrayInputStream bis = PayslipGenerator.generatePayslip(savedPayroll);

        // Optional: Save to file system (optional)
        String fileName = "payslip_" + employeeId + "_" + month + "_" + year + ".pdf";
        File targetFile = new File("generated-payslips/" + fileName);
        targetFile.getParentFile().mkdirs(); // make sure the directory exists

        FileOutputStream fos = new FileOutputStream(targetFile);
        IOUtils.copy(bis, fos);
        fos.close();

    } catch (Exception e) {
        System.out.println("Error generating payslip PDF: " + e.getMessage());
        // You can also log or handle this error
    }

    return savedPayroll;
}

    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    public Payroll getPayrollById(Long id) {
        return payrollRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payroll not found for ID: " + id));
    }
}
