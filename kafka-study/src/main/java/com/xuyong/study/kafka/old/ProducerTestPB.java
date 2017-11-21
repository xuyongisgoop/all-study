package com.xuyong.study.kafka.old;

public class ProducerTestPB {
	public static void main(String[] args) {
		ProducerClientPB producerClient = new ProducerClientPB("10.199.196.41:9092,10.199.196.42:9092,10.199.196.43:9092", "vrcp-metric");
		//ProducerClient producerClient = new ProducerClient("10.199.164.134:9092,10.199.164.135:9092,10.199.164.136:9092", "test-panpan-topic");
		new Thread(producerClient).start();
	}
}
