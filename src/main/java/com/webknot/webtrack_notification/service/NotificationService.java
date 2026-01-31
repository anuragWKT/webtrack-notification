package com.webknot.webtrack_notification.service;

import com.webknot.webtrack_notification.kafka.consumer.AllocationEvent;
import com.webknot.webtrack_notification.kafka.consumer.LeaveEvent;
import com.webknot.webtrack_notification.kafka.consumer.TimeLogEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationSender notificationSender;
    private final NotificationTemplateService templateService;

    public void handleAllocationEvent(AllocationEvent event) {
        String subject = templateService.allocationSubject(event);
        String message = templateService.allocationMessage(event);
        notificationSender.send(recipientFor(event.getUserId()), subject, message);
    }

    public void handleLeaveEvent(LeaveEvent event) {
        String subject = templateService.leaveSubject(event);
        String message = templateService.leaveMessage(event);
        notificationSender.send(recipientFor(event.getUserId()), subject, message);
    }

    public void handleTimeLogEvent(TimeLogEvent event) {
        String subject = templateService.timeLogSubject(event);
        String message = templateService.timeLogMessage(event);
        notificationSender.send(recipientFor(event.getUserId()), subject, message);
    }

    private String recipientFor(Long userId) {
        return "user-" + userId + "@example.com";
    }
}
