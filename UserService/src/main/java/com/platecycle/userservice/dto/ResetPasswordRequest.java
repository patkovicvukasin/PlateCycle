package com.platecycle.userservice.dto;

public class ResetPasswordRequest {
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
