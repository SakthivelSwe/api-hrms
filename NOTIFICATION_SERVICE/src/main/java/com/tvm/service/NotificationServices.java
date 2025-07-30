package com.tvm.service;

import com.tvm.dto.NotificationRequestDto;
import com.tvm.dto.PayslipEmailDto;

public interface NotificationServices {

    void sendOnboardingEmail(NotificationRequestDto dto);

    void sendPayslipEmail(PayslipEmailDto dto);

    void sendLeaveStatus(String toEmail, String status);

    void sendPayslipNotification(PayslipEmailDto dto);
}
