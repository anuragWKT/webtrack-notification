package com.webknot.webtrack_notification.service;

import com.webknot.webtrack_notification.kafka.consumer.AllocationEvent;
import com.webknot.webtrack_notification.kafka.consumer.LeaveEvent;
import com.webknot.webtrack_notification.kafka.consumer.TimeLogEvent;
import org.springframework.stereotype.Service;

@Service
public class NotificationTemplateService {

    public String allocationSubject(AllocationEvent event) {
        return "Allocation " + safe(event.getEventType());
    }

    public String allocationMessage(AllocationEvent event) {
        return "User " + event.getUserId() + " allocation " + safe(event.getEventType()) +
                " for project " + safe(event.getProjectCode());
    }

    public String leaveSubject(LeaveEvent event) {
        return "Leave " + safe(event.getEventType());
    }

    public String leaveMessage(LeaveEvent event) {
        return "User " + event.getUserId() + " leave " + safe(event.getEventType()) +
                " from " + event.getFromDate() + " to " + event.getToDate();
    }

    public String timeLogSubject(TimeLogEvent event) {
        return "Time log " + safe(event.getEventType());
    }

    public String timeLogMessage(TimeLogEvent event) {
        return "User " + event.getUserId() + " time log " + safe(event.getEventType()) +
                " for project " + safe(event.getProjectCode());
    }

    private String safe(String value) {
        return value == null ? "" : value;
    }
}
