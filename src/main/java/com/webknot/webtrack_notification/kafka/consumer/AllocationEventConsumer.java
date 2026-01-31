package com.webknot.webtrack_notification.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AllocationEventConsumer {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "${kafka.topics.allocation-events}", groupId = "notification-allocation-group")
    public void consumeAllocationEvent(String payload) {
        try {
            AllocationEvent event = objectMapper.readValue(payload, AllocationEvent.class);
            log.info("Allocation event received: {}", event);
        } catch (Exception ex) {
            log.error("Failed to parse allocation event", ex);
        }
    }
}
