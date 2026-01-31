package com.webknot.webtrack_notification.kafka.consumer;

import com.webknot.webtrack_notification.enums.AllocationType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AllocationEvent {
    private String eventType;
    private Long allocationId;
    private Long userId;
    private String projectCode;
    private AllocationType allocationType;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double hoursPerDay;
    private boolean manager;
    private boolean active;
    private LocalDateTime eventTime;
}
