package org.example.multithreading;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{


    BlockingQueue<String> queue;

    Producer(BlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {

        List<String> listOfProducts = Arrays.asList("Apple", "Banana", "Dragon fruit", "grapes", "orange");
        for (String str : listOfProducts) {
            try {
                System.out.println("Producer carried the fruit into freezer " + str);
                Thread.sleep(1000);
                queue.put(str);
                System.out.println("Added this fruit into freezer " + str);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
