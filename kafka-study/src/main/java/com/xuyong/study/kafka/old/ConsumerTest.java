package com.xuyong.study.kafka.old;

public class ConsumerTest {
	public static void main(String[] args) {
		ConsumerHighClient consumerHighClient = new ConsumerHighClient("10.199.196.41:2182,10.199.196.42:2182,10.199.196.43:2182", "my-replicated-topic", "xuyong-replicated-2");
		//ConsumerHighClient consumerHighClient = new ConsumerHighClient("10.199.164.134:2181,10.199.164.135:2181,10.199.164.136:2181", "test-panpan-topic", "panpan-group");
		new Thread(consumerHighClient).start();
	}
}
