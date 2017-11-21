package com.xuyong.study.kafka.old;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

public class ConsumerHighClient implements Runnable{
	private ConsumerConnector cosumerConn;
	private Properties props = new Properties();
	private String topic;
	private String groupid;
	
	public ConsumerHighClient(String zkAdrress, String topic, String groupid) {
		props.put("zookeeper.connect", zkAdrress);
		props.put("group.id", groupid);
		props.put("zookeeper.session.timeout.ms", "40000");
		props.put("zookeeper.sync.time.ms", "200");
		props.put("auto.commit.interval.ms", "1000");
		this.topic = topic;
		this.groupid = groupid;
		cosumerConn  = Consumer.createJavaConsumerConnector(new ConsumerConfig(props));
	}
	
	public void run() {
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		topicCountMap.put(topic, Integer.parseInt("1"));
		Map<String, List<KafkaStream<byte[], byte[]>>> resultMap = cosumerConn.createMessageStreams(topicCountMap);
		KafkaStream<byte[], byte[]> stream = resultMap.get(topic).get(0);
		ConsumerIterator<byte[], byte[]> it = stream.iterator();
		while (it.hasNext()) {
			System.out.println(this.groupid + " ReceivedMessage: " + new String(it.next().message()));
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}

}
