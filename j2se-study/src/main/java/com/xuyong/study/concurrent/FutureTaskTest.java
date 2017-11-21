package com.xuyong.study.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
	public static void main(String[] args) {
		TestCallableTask callable = new TestCallableTask();
		FutureTask<String> task = new FutureTask<String>(callable);
		new Thread(task).start();
		try {
			System.out.println(task.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}

class TestCallableTask implements Callable<String> {
	public String call() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
}
