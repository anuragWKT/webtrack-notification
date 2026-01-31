package com.webknot.webtrack_notification.service;

public interface NotificationSender {
    void send(String recipient, String subject, String message);
}
