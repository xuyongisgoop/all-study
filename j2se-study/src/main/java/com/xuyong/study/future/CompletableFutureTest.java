package com.xuyong.study.future;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by xuyong on 2019/12/14
 */
public class CompletableFutureTest {
    private static final ExecutorService QUERY_SHIFT_MAPPING_EXECUTOR =
            new ThreadPoolExecutor(
                    8,
                    16,
                    1L,
                    TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(50000),
                    new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        try {
            CompletableFutureTest test = new CompletableFutureTest();
            test.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            QUERY_SHIFT_MAPPING_EXECUTOR.shutdown();
        }
    }

    public List<String> commit() {
        List<Long> departmentIds = new ArrayList<>();
        departmentIds.add(1L);
        departmentIds.add(1L);
        departmentIds.add(1L);

        List<CompletableFuture<String>> futures =
                departmentIds.stream()
                             .map(
                                     departmentId -> {
                                         CompletableFuture<String> result =
                                                 new CompletableFuture<>();
                                         CompletableFuture.supplyAsync(
                                                 () -> {
                                                         try {
                                                             result.complete(
                                                                     getResult());
                                                         } catch (Exception e) {
                                                             System.out.println("queryShiftMapping CompletableFuture.supplyAsync error");
                                                             result.completeExceptionally(e);
                                                         }
                                                     return result;
                                                 },
                                                 QUERY_SHIFT_MAPPING_EXECUTOR);
                                         return result;
                                     })
                             .collect(Collectors.toList());
        return futures.stream()
                      .filter(Objects::nonNull)
                      .map(CompletableFuture::join)
                      .collect(Collectors.toList());
    }

    private static String getResult() throws Exception {
        if (true) {
            throw new IllegalArgumentException("222");
        }
        return "NEW";
    }

}
