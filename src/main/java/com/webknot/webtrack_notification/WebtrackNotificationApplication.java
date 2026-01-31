package com.webknot.webtrack_notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class WebtrackNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebtrackNotificationApplication.class, args);
	}

}
