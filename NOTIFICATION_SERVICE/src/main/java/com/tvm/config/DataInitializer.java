package com.tvm.config;


import com.tvm.model.NotificationTemplate;
import com.tvm.reposistory.NotificationTemplateRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadDefaultTemplates(NotificationTemplateRepo repository) {
        return args -> {
            if (repository.findByType("ONBOARDING").isEmpty()) {
                NotificationTemplate onboardingTemplate = new NotificationTemplate(
                        "ONBOARDING",
                        "Welcome to the Team, {name}!",
                        "Dear {name},\n\nWelcome to our company!\n\nRegards,\nHR Team"
                );
                repository.save(onboardingTemplate);
            }

            if (repository.findByType("PAYSLIP").isEmpty()) {
                NotificationTemplate payslipTemplate = new NotificationTemplate(
                        "PAYSLIP",
                        "Your Payslip for {month}",
                        "Hi {name},\n\nYour payslip for {month} is available at {url}.\n\nRegards,\nHR Team"
                );
                repository.save(payslipTemplate);
            }

            if (repository.findByType("LEAVE_STATUS").isEmpty()) {
                NotificationTemplate leaveStatusTemplate = new NotificationTemplate(
                        "LEAVE_STATUS",
                        "Leave Request Update",
                        "Your leave request has been {status}."
                );
                repository.save(leaveStatusTemplate);
            }
        };
    }
}
