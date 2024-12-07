package org.example.multithreading.basics;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    // Practise problem - utilize common resource to add and consume products - START
    static SharedResource sharedResource = new SharedResource();

    static Thread producerThread = new Thread(() -> {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sharedResource.addItem();
    });

    static Thread consumerThread = new Thread(() -> {
        sharedResource.consumeItem();
    });
    // Practise problem - utilize common resource to add and consume products - END

    public static void main(String[] args) {

        // Practise problem - utilize common resource to add and consume products - START
        Thread producerThread = new Thread(new ProducerThread(sharedResource));
        Thread consumerThread = new Thread(new ConsumerThread(sharedResource));
        consumerThread.start();
        producerThread.start();
        // Practise problem - utilize common resource to add and consume products - END

        // Below is for producer and consumer problem - my example - START
        BlockingQueue<String> storage = new ArrayBlockingQueue<>(5);
        Thread producer = new Thread(new Producer(storage));
        Thread consumer = new Thread(new Consumer(storage));
        producer.start();
        consumer.start();
        // Below is for producer and consumer problem - END

    }
}
