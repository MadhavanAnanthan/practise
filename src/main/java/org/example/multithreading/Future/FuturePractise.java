package org.example.multithreading.Future;

import java.util.concurrent.*;

// change the parameters in ThreadPoolExecutor object and understand more
public class FuturePractise {

    public static void main(String[] args) {
// executor object holds configuration about how thread's should execute
        ThreadPoolExecutor executor = new ThreadPoolExecutor
            (2, 4, 10L,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),
                new CustomThreadFactory(), new CustomRejectHandle());
       // ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.allowCoreThreadTimeOut(true);


        Future<?> future = executor.submit(() -> {
            try {
                Thread.sleep(4000);
                System.out.println("Task processed by " + Thread.currentThread().getName());
            } catch (Exception e) {
                System.out.println("error" + e.getMessage());
            }
            //return "understood";
            // If executor submit method returning any value, it is Callable
        });
        System.out.println("Task is done ? " + future.isDone());

        try{
            future.get(2, TimeUnit.SECONDS);
        }catch (Exception e) {
            System.out.println("Timeout Exception ");
        }

        try {
            System.out.println("Ready to get");
            future.get();
            System.out.println("Future obtained");
        }catch (Exception e){
            System.out.println("Exception " + e.getMessage());
        }

        System.out.println("is Done " + future.isDone());
        System.out.println("is Cancelled " + future.isCancelled());
        executor.shutdown();
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
