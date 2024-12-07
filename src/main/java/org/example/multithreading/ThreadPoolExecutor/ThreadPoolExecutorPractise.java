package org.example.multithreading.ThreadPoolExecutor;

import java.util.concurrent.*;

// change the parameters in ThreadPoolExecutor object and understand more
public class ThreadPoolExecutorPractise {

    public static void main(String[] args) {
// executor object holds configuration about how thread's should execute
        ThreadPoolExecutor executor = new ThreadPoolExecutor
            (2, 4, 10L,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),
                new CustomThreadFactory(), new CustomRejectHandle());

        executor.allowCoreThreadTimeOut(true);

        for(int i = 1; i <=7; i++){
            executor.submit(() -> {
                try{
                    Thread.sleep(3000);
                }catch (Exception e){
                    System.out.println("error" + e.getMessage());
                }
                System.out.println("Task processed by " + Thread.currentThread().getName());
            });
        }
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
