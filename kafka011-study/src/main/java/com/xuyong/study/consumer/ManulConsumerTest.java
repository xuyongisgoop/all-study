package com.xuyong.study.consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ManulConsumerTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "10.199.196.102:9092,10.199.196.1:9092,10.199.196.0:9092");
		props.put("zookeeper.connect", "10.199.196.102:2182,10.199.196.0:2182,10.199.196.1:2182");
		props.put("group.id", "xuyong-test-group-manul-zk");
		props.put("enable.auto.commit", "false");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");
		props.put("offsets.storage", "zookeeper");
		props.put("dual.commit.enabled", "false");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("vrcp_pv_metrics_message"));
		final int minBatchSize = 200;
		List<ConsumerRecord<String, String>> buffer = new ArrayList<>();
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(100);
			for (ConsumerRecord<String, String> record : records) {
				buffer.add(record);
			}
			if (buffer.size() >= minBatchSize) {
				insertIntoDb(buffer);
				consumer.commitSync();
				buffer.clear();
			}
			
//            ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);
//            for (TopicPartition partition : records.partitions()) {
//                List<ConsumerRecord<String, String>> partitionRecords = records.records(partition);
//                for (ConsumerRecord<String, String> record : partitionRecords) {
//                    System.out.println("offset = " + record.offset() + ", key = " + record.key() + ", value = " + record.value());
//                }
//                long lastOffset = partitionRecords.get(partitionRecords.size() - 1).offset();
//                consumer.commitSync(Collections.singletonMap(partition, new OffsetAndMetadata(lastOffset + 1)));
//            }
//            Map<TopicPartition, Long> endOffsets = consumer.endOffsets(records.partitions());
//            System.out.println("get last offset: ");
//            for (TopicPartition t : endOffsets.keySet()) {
//            	Long offset = endOffsets.get(t);
//            	System.out.println("partition " + t.partition() + " get last offset is " + offset);
//            }
		}
	}

	private static void insertIntoDb(List<ConsumerRecord<String, String>> buffer) {
		for (ConsumerRecord<String, String> record : buffer) {
			System.out.println("insert into offset = " + record.offset() + ", key = "
					+ record.key() + ", value = " + record.value());
		}
	}

}
