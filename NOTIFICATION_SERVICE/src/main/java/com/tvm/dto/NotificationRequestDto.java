package com.tvm.dto;

public class NotificationRequestDto {

    private String toEmail;  // Recipient's email
    private String type;     // ONBOARDING, LEAVE_STATUS.
    private String name;     // template name placeholder

    public NotificationRequestDto() {
    }

    public NotificationRequestDto(String toEmail, String type, String name) {
        this.toEmail = toEmail;
        this.type = type;
        this.name = name;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
