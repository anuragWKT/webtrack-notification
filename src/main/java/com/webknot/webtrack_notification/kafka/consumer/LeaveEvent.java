package com.webknot.webtrack_notification.kafka.consumer;

import com.webknot.webtrack_notification.enums.LeaveType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class LeaveEvent {
    private String eventType;
    private Long leaveRequestId;
    private Long userId;
    private LeaveType type;
    private LocalDate fromDate;
    private LocalDate toDate;
    private boolean halfDay;
    private String status;
    private LocalDateTime eventTime;
}
