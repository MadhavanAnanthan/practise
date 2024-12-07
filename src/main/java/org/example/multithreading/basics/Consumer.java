package org.example.multithreading.basics;

import java.util.concurrent.BlockingQueue;

public class Consumer implements  Runnable{

    BlockingQueue<String> queue;

    Consumer(BlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            while(!queue.isEmpty()){
                System.out.println("Consumer ready to pick the fruit from freezer");
                System.out.println("Consumer picked the fruit from freezer - " + queue.take());
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //
    }
}
