package com.kafka.producer;

import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

/**
 * 참고: https://www.baeldung.com/kafka-send-data-partition#1-what-are-kafka-partitions
 */
public class CustomPartitioner implements Partitioner {

	public static final int PREMIUM_PARTITION = 0;
	public static final int NORMAL_PARTITION = 1;

	@Override
	public int partition(final String topic, final Object key, final byte[] keyBytes, final Object value,
		final byte[] valueBytes, final Cluster cluster) {
		String customerType = extractCustomerType(key.toString());
		return "premium".equalsIgnoreCase(customerType) ? PREMIUM_PARTITION : NORMAL_PARTITION;
	}

	private String extractCustomerType(final String key) {
		String[] parts = key.split("-");
		return parts.length > 1 ? parts[1] : "normal";
	}

	@Override
	public void close() {

	}

	@Override
	public void configure(final Map<String, ?> configs) {

	}
}
