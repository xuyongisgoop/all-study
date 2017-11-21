//package com.xuyong.study.consumer;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;
//import java.util.concurrent.ExecutionException;
//
//import org.apache.kafka.clients.admin.AdminClient;
//import org.apache.kafka.clients.admin.DescribeTopicsResult;
//import org.apache.kafka.clients.admin.ListTopicsResult;
//import org.apache.kafka.clients.admin.TopicDescription;
//import org.apache.kafka.clients.admin.TopicListing;
//import org.apache.kafka.common.KafkaFuture;
//import org.apache.kafka.common.TopicPartitionInfo;
//
//public class MetaAdminClientTest {
//
//	public static void main(String[] args) {
//		Properties props = new Properties();
//		props.put("bootstrap.servers",
//				"10.199.196.102:9092,10.199.196.1:9092,10.199.196.0:9092");
//		AdminClient adminClient = AdminClient.create(props);
//		ListTopicsResult listTopics = adminClient.listTopics();
//		KafkaFuture<Collection<TopicListing>> listings = listTopics.listings();
//		try {
//			Collection<TopicListing> collection = listings.get();
//			for (TopicListing t : collection) {
//				System.out.println(t.name());
//				String[] topicArr = { t.name() };
//				DescribeTopicsResult describeTopics = adminClient
//						.describeTopics(Arrays.asList(topicArr));
//				Map<String, KafkaFuture<TopicDescription>> values = describeTopics
//						.values();
//				KafkaFuture<TopicDescription> kafkaFuture = values
//						.get(t.name());
//				TopicDescription topicDescription = kafkaFuture.get();
//				List<TopicPartitionInfo> partitions = topicDescription
//						.partitions();
//				for (TopicPartitionInfo topicPartitionInfo : partitions) {
//					System.out.println(topicPartitionInfo.isr());
//					System.out.println(topicPartitionInfo.leader());
//				}
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}
//
//		// ≤È—ØtopicœÍ«È
//	}
//
//}
