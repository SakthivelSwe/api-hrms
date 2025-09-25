package com.tvm.controller;


import com.tvm.dto.NotificationRequestDto;
import com.tvm.dto.PayslipEmailDto;
import com.tvm.service.NotificationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationServices notificationService;

    // Onboarding
    @PostMapping("/onboarding")
    public ResponseEntity<String> sendOnboardingEmail(@RequestBody NotificationRequestDto dto) {
        notificationService.sendOnboardingEmail(dto);
        return ResponseEntity.ok("Onboarding Email sent successfully.");
    }

    // Payslip
    @PostMapping("/sendPayslip")
    public ResponseEntity<String> sendPayslipEmail(@RequestBody PayslipEmailDto dto) {
        notificationService.sendPayslipEmail(dto);
        return ResponseEntity.ok("Payslip Email sent successfully.");
    }

    // Leave status
    @PostMapping("/leaveStatus")
    public ResponseEntity<String> sendLeaveStatusEmail(
            @RequestParam String toEmail,
            @RequestParam String status
    ) {
        notificationService.sendLeaveStatus(toEmail, status);
        return ResponseEntity.ok("Leave status mail sent successfully.");
    }
}

