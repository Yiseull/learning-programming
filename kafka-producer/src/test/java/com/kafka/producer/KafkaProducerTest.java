package com.kafka.producer;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KafkaProducerTest {

	@Autowired
	KafkaProducer kafkaProducer;

	@Test
	void testSendMessage() {
		kafkaProducer.sendMessage("yiseul-normal", "저는 일반 고객입니다.");
		kafkaProducer.sendMessage("sul-premium", "설이(우리집 강아지임)는 프리미엄 고객입니다.");
	}
}