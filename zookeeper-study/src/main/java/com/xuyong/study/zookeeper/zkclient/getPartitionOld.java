package com.xuyong.study.zookeeper.zkclient;

public class getPartitionOld {
	public static void main(String[] args) {
		ZkUtil zk = new ZkUtil("10.199.196.41:2182,10.199.196.42:2182,10.199.196.43:2182");
		System.out.println(zk.getChildren("/brokers/topics/data_clean_target_topic/partitions").size());
	}
}
