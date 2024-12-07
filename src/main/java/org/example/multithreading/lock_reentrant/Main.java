package org.example.multithreading.lock_reentrant;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        System.out.println("Time start - " + LocalDateTime.now());

        SharedResource sharedResource = new SharedResource();
        ReentrantLock reentrantLock = new ReentrantLock();

        System.out.println("Current thread - " + Thread.currentThread().getName());
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " - calling produce method");
            sharedResource.produce(reentrantLock, Thread.currentThread().getName());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " - calling produce method");
            sharedResource.produce(reentrantLock, Thread.currentThread().getName());
        });

        thread1.start();
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
