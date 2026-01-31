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
public class LeaveEventConsumer {

    private final ObjectMapper objectMapper;
    private final NotificationService notificationService;

    @KafkaListener(topics = "${kafka.topics.leave-events}", groupId = "notification-leave-group")
    public void consumeLeaveEvent(String payload) {
        try {
            LeaveEvent event = objectMapper.readValue(payload, LeaveEvent.class);
            log.info("Leave event received: {}", event);
            notificationService.handleLeaveEvent(event);
        } catch (Exception ex) {
            log.error("Failed to parse leave event", ex);
        }
    }
}
