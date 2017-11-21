package com.xuyong.study.redis;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisUtilsTest {
	private Jedis jedis;

	@Before
	public void setUp() throws Exception {
		System.out.println("init");
		jedis = new Jedis("10.199.196.102", 6379);
	}

	@Test
	public void test() {
		Map<String, String> targetResult = new HashMap<String, String>();
		targetResult.put("key1", "val1");
		targetResult.put("key2", "val2");
		targetResult.put("key3", "val3");
		assertEquals("", targetResult, RedisUtils.hashTest(jedis));
	}

}
