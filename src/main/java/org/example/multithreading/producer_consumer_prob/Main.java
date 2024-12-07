package org.example.multithreading.producer_consumer_prob;

import org.example.multithreading.basics.*;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {

        // Below is for producer and consumer problem - START
        SharedBuffer sharedBuffer = new SharedBuffer(3);
        Thread producer = new Thread(()-> {
        for(int i = 1; i <= 6; i++){
            sharedBuffer.produce(i);
        }
        });
        Thread consumer = new Thread(()->{
            for(int i = 1; i <= 6; i++) {
                sharedBuffer.consume();
            }
        });
        consumer.start();
        producer.start();

        // Below is for producer and consumer problem - END

    }
}
