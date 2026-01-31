package com.webknot.webtrack_notification.service.impl;

import com.webknot.webtrack_notification.service.NotificationSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsoleNotificationSender implements NotificationSender {

    @Override
    public void send(String recipient, String subject, String message) {
        log.info("Notification to {} | {} | {}", recipient, subject, message);
    }
}
