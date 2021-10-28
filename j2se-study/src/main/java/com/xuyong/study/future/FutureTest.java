package com.xuyong.study.future;

import java.util.concurrent.CompletableFuture;

/**
 * Created by xuyong on 2019/12/14
 */
public class FutureTest {

    public static void main(String[] args) {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.whenComplete((r, t) -> {

        });

    }

}
