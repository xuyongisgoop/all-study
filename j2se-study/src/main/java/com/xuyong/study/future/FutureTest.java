package com.xuyong.study.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by xuyong on 2019/12/14
 */
public class FutureTest {
    private static final ExecutorService QUERY_SHIFT_MAPPING_EXECUTOR =
            new ThreadPoolExecutor(
                    8,
                    16,
                    1L,
                    TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(50000),
                    new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try {
            FutureTest test = new FutureTest();
            test.commit();
        } catch (Exception e) {
            QUERY_SHIFT_MAPPING_EXECUTOR.shutdown();
        }
    }

    public void commit() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        CompletableFuture.supplyAsync(() -> {
            try {
                future.complete(getResult());
            } catch (Exception e) {
                System.out.println("error");
                future.completeExceptionally(e);
            }
            return future;
        }, QUERY_SHIFT_MAPPING_EXECUTOR);
        System.out.println(future.get());
        System.out.println("=============");
    }

    private static String getResult() {
        if (true) {
            throw new IllegalArgumentException("222");
        }
        return "NEW";
    }

}
