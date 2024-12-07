package org.example.multithreading.CompletableFuture;

import java.util.concurrent.*;


public class ThenApplyAsync_Practise {

    public static void main(String[] args) {
// executor object holds configuration about how thread's should execute

        ThreadPoolExecutor executor = new ThreadPoolExecutor
            (2, 4, 10L,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread name of supplyAsync "+ Thread.currentThread().getName());
            return "task done by -" + Thread.currentThread().getName();
        }, executor);
        CompletableFuture<String> stringCompletableFuture = supplyAsync.thenApply((String value) -> {
            System.out.println("Thread name of thenApply " + Thread.currentThread().getName());
            return "all task done by -" + Thread.currentThread().getName();
        });


        try {
            String s = stringCompletableFuture.get();
            System.out.println(s);
        }catch (Exception e){
            //
        }

    }

}


