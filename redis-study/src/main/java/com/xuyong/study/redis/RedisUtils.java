package com.xuyong.study.redis;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisUtils {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("10.199.196.102", 6379);
	    jedis.set("testxuyong", "2333");
	    jedis.incrBy("testxuyong", 2);
	    System.out.println(jedis.get("greet-key"));
	    System.out.println(jedis.get("testxuyong"));
	    System.out.println(jedis.del("testxuyong"));
	    
	    System.out.println("=========================");
	    
	    listTest(jedis);
	    
	    System.out.println("=========================");
	    
	    setTest(jedis);
	    
	    System.out.println("=========================");
	    
	    hashTest(jedis);
	    
	    System.out.println("=========================");
	    
	    zsetTest(jedis);
	    
	    jedis.close();
	}

	public static void zsetTest(Jedis jedis) {
	    jedis.zadd("xuyongzset", -1, "zset1");
	    jedis.zadd("xuyongzset", 2, "zset2");
	    jedis.zadd("xuyongzset", 3, "zset3");
	    jedis.zadd("xuyongzset", 4, "zset4");
	    jedis.zadd("xuyongzset", 5, "zset5");
	    Set<String> zrange = jedis.zrange("xuyongzset", 0, -1);
	    for (String z : zrange) {
	    	System.out.println(z);
	    }
	    
	    Set<String> zrangescore = jedis.zrangeByScore("xuyongzset", 1, 5);
	    for (String z : zrangescore) {
	    	System.out.println(z);
	    }
	    System.out.println(jedis.zrem("xuyongzset", "zset3"));		
	}

	public static Map<String, String> hashTest(Jedis jedis) {
	    jedis.hset("xuyonghash", "key1", "val1");
	    jedis.hset("xuyonghash", "key2", "val2");
	    jedis.hset("xuyonghash", "key3", "val3");
	    jedis.hset("xuyonghash", "key3", "val3");
	    Map<String, String> hgetAll = jedis.hgetAll("xuyonghash");
	    Set<Entry<String, String>> entrySet = hgetAll.entrySet();
//	    for (Entry<String, String> entr : entrySet) {
//	    	System.out.println(entr.getKey() + " : " + entr.getValue());
//	    }
//	    System.out.println("get key2: " + jedis.hget("xuyonghash", "key2"));
//	    System.out.println("del key2:" + jedis.hdel("xuyonghash", "key2"));		
	    return hgetAll;
	}

	public static void setTest(Jedis jedis) {
	    jedis.sadd("xuyongset", "set1");
	    jedis.sadd("xuyongset", "set2");
	    jedis.sadd("xuyongset", "set3");
	    jedis.sadd("xuyongset", "set4");
	    jedis.sadd("xuyongset", "set1");
	    Set<String> smembers = jedis.smembers("xuyongset");
	    for (String s : smembers) {
	    	System.out.println(s);
	    }
	    System.out.println("check set4 if in: " + jedis.sismember("xuyongset", "set4"));
	    System.out.println("check remove: " + jedis.srem("xuyongset", "set4"));		
	}

	public static void listTest(Jedis jedis) {
	    jedis.rpush("xuyonglist", "list1");
	    jedis.rpush("xuyonglist", "list2");
	    jedis.rpush("xuyonglist", "list3");
	    jedis.rpush("xuyonglist", "list4");
	    jedis.rpush("xuyonglist", "list1");
	    List<String> lrange = jedis.lrange("xuyonglist", 0, -1);
	    for (String l : lrange) {
	    	System.out.println(l);
	    }
	    System.out.println("get index 1: " + jedis.lindex("xuyonglist", 1));
	    System.out.println("pop a value: " + jedis.rpop("xuyonglist"));		
	}
}
