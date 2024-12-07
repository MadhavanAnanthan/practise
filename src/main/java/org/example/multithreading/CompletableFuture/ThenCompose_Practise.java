package org.example.multithreading.CompletableFuture;

import java.util.concurrent.*;


public class ThenCompose_Practise {

    public static void main(String[] args) {
// executor object holds configuration about how thread's should execute

        ThreadPoolExecutor executor = new ThreadPoolExecutor
            (2, 4, 10L,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread name of supplyAsync "+ Thread.currentThread().getName());
            return "task done by -" + Thread.currentThread().getName();
        }, executor).thenCompose((String value) -> {
            System.out.println("Thread name of thenCompose-1 " + Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> "all task done by -" + Thread.currentThread().getName());
        }).thenCompose((String value) -> {
            System.out.println("Thread name of thenCompose-2 " + Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> "all task done by -" + Thread.currentThread().getName());
        });

        executor.shutdown();
    }

}


