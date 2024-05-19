package com.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * 파티션 참고: https://www.baeldung.com/spring-kafka
 * premium 고객은 0번 파티션에서, 일반 고객은 1번 파티션에서 메시지를 소비합니다.
 */
@Component
public class KafkaConsumer {
	@KafkaListener(topicPartitions = @TopicPartition(topic = "topic", partitions = "0"), groupId = "consumer_group")
	public void consumePremium(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition, @Header(KafkaHeaders.RECEIVED_KEY) String key) {
		System.out.println(key + " 고객의 메시지: " + message + " 파티션: " + partition);
	}


	@KafkaListener(topicPartitions = @TopicPartition(topic = "topic", partitions = "1"), groupId = "consumer_group")
	public void consumeNormal(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition, @Header(KafkaHeaders.RECEIVED_KEY) String key) {
		System.out.println(key + " 고객의 메시지: " + message + " 파티션: " + partition);
	}
}
