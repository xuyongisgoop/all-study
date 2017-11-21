package com.xuyong.study.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * @author jetty.xu
 *
 */
public class CacheTest {

	public static void main(String[] args) {
		LoadingCache<String, String> cache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.SECONDS).build(new CacheLoader<String, String>() {
			@Override
			public String load(String key) throws Exception {
				return "NULL";
			}
		});
		cache.put("larry", "good");
		cache.put("larry1", "good1");
		cache.put("larry2", "good2");
		cache.put("larry3", "good3");
		cache.put("larry4", "good4");
		cache.put("larry5", "good5");
		cache.put("larry6", "good6");
		cache.put("larry7", "good7");
		try {
			System.out.println(cache.get("larry"));
			System.out.println(cache.get("larry1"));
			System.out.println(cache.get("larry2"));
			System.out.println(cache.get("larry3"));
			System.out.println(cache.get("larry4"));
			Thread.sleep(2000);
			System.out.println(cache.get("larry5"));
			System.out.println(cache.get("larry6"));
			System.out.println(cache.get("larry7"));
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
