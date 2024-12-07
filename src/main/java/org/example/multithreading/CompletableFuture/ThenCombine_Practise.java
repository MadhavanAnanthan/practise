package org.example.multithreading.CompletableFuture;

import java.util.concurrent.*;


public class ThenCombine_Practise {

    public static void main(String[] args) {
// executor object holds configuration about how thread's should execute

        ThreadPoolExecutor executor = new ThreadPoolExecutor
            (2, 4, 10L,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread name of supplyAsync "+ Thread.currentThread().getName());
            return 10;
        }, executor);

        CompletableFuture<String> supplyAsync1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread name of supplyAsync "+ Thread.currentThread().getName());
            return "Thousand";
        }, executor);


        try {
            System.out.println(supplyAsync.thenCombine(supplyAsync1, (intVal, strVal)-> {
                return intVal + strVal;
            }).get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();
    }

}


