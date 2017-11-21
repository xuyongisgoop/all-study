package com.xuyong.study.zookeeper.curator;

public class getPartitionMain {
	public static void main(String[] args) {
		// curator支持传入zk节点中有反斜杠路径
		PartitionGetter pg = new PartitionGetter("mars-sc", "10.199.209.246:2181/kafkaztest");
		System.out.println(pg.getNumPartitions());
	}
}
