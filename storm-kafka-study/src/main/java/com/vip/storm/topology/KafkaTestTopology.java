package com.vip.storm.topology;

import java.util.Arrays;
import java.util.Properties;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.kafka.BrokerHosts;
import org.apache.storm.kafka.KafkaSpout;
import org.apache.storm.kafka.SpoutConfig;
import org.apache.storm.kafka.StringScheme;
import org.apache.storm.kafka.ZkHosts;
import org.apache.storm.spout.SchemeAsMultiScheme;
import org.apache.storm.topology.TopologyBuilder;

import com.vip.storm.bolt.CleanBolt;
import com.vip.storm.common.ConfigUtil;

public class KafkaTestTopology {
	public static void main(String[] args) throws Exception {
	    Properties prop = ConfigUtil.readFile(args[0]);
	    String consumer = prop.getProperty("consumer");
		TopologyBuilder builder = new TopologyBuilder();
		// 生成kafkaSpout
		BrokerHosts hosts = new ZkHosts(
				"10.199.196.41:2182,10.199.196.42:2182,10.199.196.43:2182");
		SpoutConfig spoutConfig = new SpoutConfig(hosts, "kafka-monitor-test",
				"/" + "kafka-monitor-test", consumer);
		spoutConfig.scheme = new SchemeAsMultiScheme(new StringScheme());
		String[] zhosts = {"10.199.196.41", "10.199.196.42", "10.199.196.43"};
		spoutConfig.zkServers = Arrays.asList(zhosts); // where offset commit to zk
		spoutConfig.zkPort = 2183;
		KafkaSpout kafkaSpout = new KafkaSpout(spoutConfig);
		// 生成kafkaBolt
//	    Properties props = new Properties();
//	    props.put("metadata.broker.list", "10.199.196.41:9092,10.199.196.42:9092,10.199.196.43:9092");
//	    props.put("request.required.acks", "1");
//	    props.put("serializer.class", "kafka.serializer.StringEncoder");
//		KafkaBolt kafkaBolt = new KafkaBolt().withTopicSelector(
//				new DefaultTopicSelector("test")).withTupleToKafkaMapper(
//				new FieldNameBasedTupleToKafkaMapper()).withProducerProperties(props);
		builder.setSpout("kafka_spout", kafkaSpout, 1);
		builder.setBolt("clean_bolt", new CleanBolt(), 1).shuffleGrouping(
				"kafka_spout");
		//builder.setBolt("kafka_bolt", kafkaBolt).shuffleGrouping("clean_bolt");

		Config conf = new Config();
		conf.setDebug(true);
		if (args != null && args.length > 0) {
			conf.setNumWorkers(3); 
			StormSubmitter.submitTopology("kafka-spout-test-topology", conf, builder.createTopology());
		} else {
			LocalCluster localCluster = new LocalCluster();
			localCluster.submitTopology("kafka-spout-test-topology", conf, builder.createTopology());
		}
	}
}
