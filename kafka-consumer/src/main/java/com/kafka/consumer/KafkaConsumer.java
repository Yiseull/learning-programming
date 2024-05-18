package com.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	@KafkaListener(topics = "topic", groupId = "consumer_group")
	public void consume(String message) {
		System.out.println("Consumed message: " + message);
	}
}
