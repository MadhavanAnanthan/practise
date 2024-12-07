package org.example.multithreading.CompletableFuture;

import java.util.concurrent.*;


public class SupplyAsync_Practise {

    public static void main(String[] args) {
// executor object holds configuration about how thread's should execute

        ThreadPoolExecutor executor = new ThreadPoolExecutor
            (2, 4, 10L,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),
                new CustomThreadFactory(), new CustomRejectHandle());

        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            return "task done by -" + Thread.currentThread().getName();
        }); // o/p - task done by -ForkJoinPool.commonPool-worker-1

        CompletableFuture<String> supplyAsync1 = CompletableFuture.supplyAsync(() -> {
            return "task done by -" + Thread.currentThread().getName();
        }, executor); // o/p - task done by -Thread-0

        try {
            String s = supplyAsync.get();
            System.out.println(s);
        }catch (Exception e){
            //
        }

    }

}

// created custom CustomThreadFactory to assign name, priority and daemon
class CustomThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        // threads can have same same
        //thread.setName("Custom Thread");
        return thread;
    }
}


// created custom reject handle
class CustomRejectHandle implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected : " + r.toString());
    }
}
