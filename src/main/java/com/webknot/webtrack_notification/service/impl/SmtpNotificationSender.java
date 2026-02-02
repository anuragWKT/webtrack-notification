package com.webknot.webtrack_notification.service.impl;

import com.webknot.webtrack_notification.service.NotificationSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Primary
@RequiredArgsConstructor
public class SmtpNotificationSender implements NotificationSender {

    private final JavaMailSender mailSender;

    @Value("${notification.from:no-reply@webtrack.local}")
    private String fromAddress;

    @Override
    public void send(String recipient, String subject, String message) {
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setFrom(fromAddress);
            mail.setTo(recipient);
            mail.setSubject(subject);
            mail.setText(message);
            mailSender.send(mail);
            log.info("Email sent to {} with subject {}", recipient, subject);
        } catch (Exception ex) {
            log.error("Failed to send email to {}", recipient, ex);
        }
    }
}
