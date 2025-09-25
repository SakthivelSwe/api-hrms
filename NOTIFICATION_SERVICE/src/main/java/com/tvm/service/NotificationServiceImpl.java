package com.tvm.service;

import com.tvm.dto.NotificationRequestDto;
import com.tvm.dto.PayslipEmailDto;
import com.tvm.model.NotificationModel;
import com.tvm.model.NotificationTemplate;
import com.tvm.reposistory.NotificationReposistory;
import com.tvm.reposistory.NotificationTemplateRepo;
import com.tvm.util.EmailSenderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationServices {

    @Autowired
    private EmailSenderUtil emailSenderUtil;

    @Autowired
    private NotificationReposistory logRepository;

    @Autowired
    private NotificationTemplateRepo templateRepo;

    // Onboarding Email
    @Override
    public void sendOnboardingEmail(NotificationRequestDto dto) {
        System.out.println("Sending onboarding email to: " + dto.getToEmail());

        Optional<NotificationTemplate> templateOpt = templateRepo.findByType("ONBOARDING");

        if (templateOpt.isPresent()) {
            NotificationTemplate template = templateOpt.get();
            String subject = template.getSubject();
            String body = template.getBody().replace("{name}", dto.getName());

            emailSenderUtil.sendEmail(dto.getToEmail(), subject, body);

            NotificationModel log = new NotificationModel(dto.getToEmail(), subject, body, LocalDateTime.now());
            log.setType("ONBOARDING");
            logRepository.save(log);
        } else {
            System.out.println("Template for ONBOARDING not found in DB");
        }
    }

    // Payslip Email
    @Override
    public void sendPayslipEmail(PayslipEmailDto dto) {
        System.out.println("Sending payslip email to: " + dto.getEmployeeEmail());

        Optional<NotificationTemplate> templateOpt = templateRepo.findByType("PAYSLIP");

        if (templateOpt.isPresent()) {
            NotificationTemplate template = templateOpt.get();
            String subject = template.getSubject();
            String body = template.getBody()
                    .replace("{name}", dto.getEmployeeName())
                    .replace("{month}", dto.getMonth())
                    .replace("{url}", dto.getPayslipUrl());

            emailSenderUtil.sendEmail(dto.getEmployeeEmail(), subject, body);

            NotificationModel log = new NotificationModel(dto.getEmployeeEmail(), subject, body, LocalDateTime.now());
            log.setType("PAYSLIP");
            logRepository.save(log);
        } else {
            System.out.println("Template for PAYSLIP not found in DB");
        }
    }

    // Leave Status Email
    @Override
    public void sendLeaveStatus(String toEmail, String status) {
        System.out.println("Sending leave status email to: " + toEmail);

        Optional<NotificationTemplate> templateOpt = templateRepo.findByType("LEAVE_STATUS");

        if (templateOpt.isPresent()) {
            NotificationTemplate template = templateOpt.get();
            String subject = template.getSubject();
            String body = template.getBody().replace("{status}", status);

            emailSenderUtil.sendEmail(toEmail, subject, body);

            NotificationModel log = new NotificationModel(toEmail, subject, body, LocalDateTime.now());
            log.setType("LEAVE_STATUS");
            logRepository.save(log);
        } else {
            System.out.println("Template for LEAVE_STATUS not found in DB");
        }
    }

    // Fallback (no-template) Payslip Email
    @Override
    public void sendPayslipNotification(PayslipEmailDto dto) {
        String subject = "Your Monthly Payslip";
        String body = "Hello " + dto.getEmployeeName() + ",\n\n"
                + "Please find your payslip for the month of " + dto.getMonth() + " here: " + dto.getPayslipUrl() + "\n\n"
                + "Thanks,\nHR Team";

        emailSenderUtil.sendEmail(dto.getEmail(), subject, body);

        NotificationModel log = new NotificationModel(dto.getEmail(), subject, body, LocalDateTime.now());
        log.setType("FALLBACK_PAYSLIP");
        logRepository.save(log);
    }
}
