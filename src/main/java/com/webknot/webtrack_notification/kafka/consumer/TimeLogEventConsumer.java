package com.webknot.webtrack_notification.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webknot.webtrack_notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TimeLogEventConsumer {

    private final ObjectMapper objectMapper;
    private final NotificationService notificationService;

    @KafkaListener(topics = "${kafka.topics.timelog-events}", groupId = "notification-timelog-group")
    public void consumeTimeLogEvent(String payload) {
        try {
            TimeLogEvent event = objectMapper.readValue(payload, TimeLogEvent.class);
            log.info("Time log event received: {}", event);
            notificationService.handleTimeLogEvent(event);
        } catch (Exception ex) {
            log.error("Failed to parse time log event", ex);
        }
    }
}
