package com.xuyong.study.zookeeper.curator;

public class getPartitionMain {
	public static void main(String[] args) {
		// curator֧�ִ���zk�ڵ����з�б��·��
		PartitionGetter pg = new PartitionGetter("mars-sc", "10.199.209.246:2181/kafkaztest");
		System.out.println(pg.getNumPartitions());
	}
}
