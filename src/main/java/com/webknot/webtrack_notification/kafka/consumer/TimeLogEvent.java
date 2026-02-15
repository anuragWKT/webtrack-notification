package com.webknot.webtrack_notification.kafka.consumer;

import com.webknot.webtrack_notification.enums.TimeLogStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TimeLogEvent {
    private String eventType;
    private Long timeLogId;
    private Long userId;
    private String projectCode;
    private LocalDate logDate;
    private Double hours;
    private TimeLogStatus status;
    private LocalDateTime eventTime;
}
