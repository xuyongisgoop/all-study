package com.xuyong.study.consumer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import kafka.admin.AdminClient;
import kafka.admin.AdminClient.ConsumerGroupSummary;
import kafka.coordinator.group.GroupOverview;

import org.apache.kafka.clients.NodeApiVersions;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.TopicPartition;

import scala.Option;
import scala.collection.Iterator;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Set;
import scala.util.Try;

public class GroupAdminClientTest {
	
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "10.199.196.102:9092,10.199.196.1:9092,10.199.196.0:9092");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		AdminClient adminClient = AdminClient.create(props);
		Map<TopicPartition, Object> listGroupOffsets = adminClient.listGroupOffsets("storm-metric-persistent-flink");
		Set<TopicPartition> keySet = listGroupOffsets.keySet();
		Iterator<TopicPartition> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			TopicPartition tp = iterator.next();
			Option<Object> option = listGroupOffsets.get(tp);
			System.out.println("partition: " + tp.partition() + ", optition: " + option.get());
		}
		
		//Map<Node, List<GroupOverview>> listAllConsumerGroups = adminClient.listAllGroups();
		Map<Node, List<GroupOverview>> listAllConsumerGroups = adminClient.listAllConsumerGroups();
		Set<Node> allGroups = listAllConsumerGroups.keySet();
		Iterator<Node> nodes = allGroups.iterator();
		while (nodes.hasNext()) {
			Node nd = nodes.next();
			Option<List<GroupOverview>> groups = listAllConsumerGroups.get(nd);
			List<GroupOverview> list = groups.get();
			Iterator<GroupOverview> glist = list.iterator();
			while (glist.hasNext()) {
				GroupOverview view = glist.next();
				System.out.println("group overview is " + view.groupId());
				
				// 获取group详情、取group对应的topic
				ConsumerGroupSummary describeConsumerGroup = adminClient.describeConsumerGroup(view.groupId(), 1000);
				//ConsumerGroupSummary describeConsumerGroup = adminClient.describeConsumerGroup(view.groupId());
				describeConsumerGroup.state();
				Map<TopicPartition, Object> listGroupOffsetsNew = adminClient.listGroupOffsets(view.groupId());
				Set<TopicPartition> keySet2 = listGroupOffsetsNew.keySet();
				Iterator<TopicPartition> iterator2 = keySet2.iterator();
				while (iterator2.hasNext()) {
					TopicPartition topic = iterator2.next();
					Option<Object> option = listGroupOffsetsNew.get(topic);
					Object object = option.get();
					System.out.println(topic.topic());
					System.out.println(object);// 实际是offset
					
					// 取得logsize
					KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
					Collection<TopicPartition> topicList = new ArrayList<TopicPartition>();
					topicList.add(topic);
					java.util.Map<TopicPartition, Long> endOffsets = consumer.endOffsets(topicList);
					Long logsize = endOffsets.get(topic);
					System.out.println(logsize);
					consumer.close();
				}
			}
		}
		
	    scala.collection.immutable.Map<Node, Try<NodeApiVersions>> listAllBrokerVersionInfo = adminClient.listAllBrokerVersionInfo();
	    scala.collection.Iterable<Node> keys = listAllBrokerVersionInfo.keys();
	    Iterator<Node> iterator1 = keys.iterator();
	    while (iterator1.hasNext()) {
	      Node next = iterator1.next();
	      Option<Try<NodeApiVersions>> option = listAllBrokerVersionInfo.get(next);
	      Try<NodeApiVersions> tryNode = option.get();
	      NodeApiVersions nodeApiVersions = tryNode.get();
	      System.out.println(next.id());
	      System.out.println(nodeApiVersions);
	    }
	}
}
