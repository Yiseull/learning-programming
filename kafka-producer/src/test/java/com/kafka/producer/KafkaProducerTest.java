package com.kafka.producer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KafkaProducerTest {

	@Autowired
	KafkaProducer kafkaProducer;

	@Test
	void testSendMessage() {
		kafkaProducer.sendMessage("Hello World!");
	}
}