package org.example.multithreading.lock_stampedLock;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        System.out.println("Time start - " + LocalDateTime.now());

        SharedResource sharedResource = new SharedResource();

        System.out.println("Current thread - " + Thread.currentThread().getName());

        Thread thread1 = new Thread(() -> {
            sharedResource.consume( Thread.currentThread().getName());
        });
        Thread thread3 = new Thread(() -> {
            sharedResource.consume( Thread.currentThread().getName());
        });

        Thread thread2 = new Thread(() -> {
            sharedResource.produce(Thread.currentThread().getName());
        });

        thread1.start();
        thread3.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }catch (Exception e){

        }

        System.out.println("Ended - " + Thread.currentThread().getName());
        System.out.println("Time ended - " + LocalDateTime.now());
    }
}
