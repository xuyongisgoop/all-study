package com.xuyong.study.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProducerTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "10.199.196.102:9092,10.199.196.1:9092,10.199.196.0:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<>(props);
		for (int i = 0; i < 100; i++)
			producer.send(new ProducerRecord<String, String>("vrcp_pv_metrics_message",
					Integer.toString(i), Integer.toString(i)));
		producer.close();
	}
}
