package com.kafka.producer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

/**
 * 참고: https://www.baeldung.com/kafka-topics-partitions
 */
@Configuration
public class KafkaTopicConfig {
	@Bean
	public KafkaAdmin kafkaAdmin() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		return new KafkaAdmin(config);
	}

	@Bean
	public NewTopic topic() {
		return TopicBuilder.name("topic")
			.partitions(2)
			.build();
	}
}
