package com.tvm.controller;

import com.tvm.entity.Payroll;
import com.tvm.service.PayrollService;
import com.tvm.util.PayslipGenerator;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/payrolls")
@RequiredArgsConstructor
public class PayrollController {

    private final PayrollService payrollService;


    @PostMapping
    public ResponseEntity<Payroll> processPayroll(@RequestBody Payroll payroll) {
        Payroll processed = payrollService.processPayroll(
                payroll.getEmployeeId(),
                payroll.getMonth(),
                payroll.getYear()
        );
        return ResponseEntity.ok(processed);
    }



    @GetMapping
    public ResponseEntity<List<Payroll>> getAllPayrolls() {
        return ResponseEntity.ok(payrollService.getAllPayrolls());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Payroll> getPayrollById(@PathVariable Long id) {
        return ResponseEntity.ok(payrollService.getPayrollById(id));
    }
//    @GetMapping("/{id}/payslip/pdf")
//    public void getPayslipPdf(@PathVariable Long id, HttpServletResponse response) throws IOException {
//        Payroll payroll = payrollService.getPayrollById(id);
//        Object PayslipGenerator = null;
//        ByteArrayInputStream bis = PayslipGenerator.generatePayslipPdf(payroll);
//
//        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
//        response.setHeader("Content-Disposition", "attachment; filename=payslip_" + id + ".pdf");
//
//        IOUtils.copy(bis, response.getOutputStream());
//        response.flushBuffer();
//    }

    @GetMapping("/{id}/payslip/pdf")
    public void getPayslipPdf(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Payroll payroll = payrollService.getPayrollById(id);

        ByteArrayInputStream bis = PayslipGenerator.generatePayslip(payroll); // Correct usage

        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-Disposition", "attachment; filename=payslip_" + id + ".pdf");

        IOUtils.copy(bis, response.getOutputStream());
        response.flushBuffer();
    }

}
