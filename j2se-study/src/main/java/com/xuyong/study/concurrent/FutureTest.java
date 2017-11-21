package com.xuyong.study.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTest {
	
	public static void main(String[] args) {
		ExecutorService fixedExecutors = Executors.newFixedThreadPool(5);
		TestCallable t = new TestCallable();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(new Date()));
		try {
			Thread.sleep(1*1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		Future<String> resultFutrue = fixedExecutors.submit(t);
		try {
			Thread.sleep(20*1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		try {
			String result = resultFutrue.get(1, TimeUnit.SECONDS);
			System.out.println("get reusult: " + result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		fixedExecutors.shutdown();
	}
	
}

class TestCallable implements Callable<String> {
	public String call() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
}
