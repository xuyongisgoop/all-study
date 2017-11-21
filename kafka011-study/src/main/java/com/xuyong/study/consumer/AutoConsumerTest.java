package com.xuyong.study.consumer;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class AutoConsumerTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers",
				"10.199.196.102:9092,10.199.196.1:9092,10.199.196.0:9092");
		props.put("zookeeper.connect", "10.199.196.102:2182,10.199.196.0:2182,10.199.196.1:2182");
		props.put("group.id", "xuyong-test-group-auto");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");
		props.put("offsets.storage", "zookeeper");
		props.put("dual.commit.enabled", "false");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(
				props);
		
		// 消费数据
		consumer.subscribe(Arrays.asList("vrcp_pv_metrics_message"));
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(1);
			for (ConsumerRecord<String, String> record : records)
				System.out.println("offset = " + record.offset() + ", key = "
						+ record.key() + ", value = " + record.value());
		}
	}
}
