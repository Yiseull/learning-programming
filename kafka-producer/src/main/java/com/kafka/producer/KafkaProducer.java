package com.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public KafkaProducer(final KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(final String key, final String message) {
		kafkaTemplate.send("topic", key, message);
	}
}
