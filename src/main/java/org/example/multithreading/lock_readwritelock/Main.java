package org.example.multithreading.lock_readwritelock;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String[] args) {

        System.out.println("Time start - " + LocalDateTime.now());

        SharedResource sharedResource = new SharedResource();

        ReadWriteLock lock = new ReentrantReadWriteLock();


        System.out.println("Current thread - " + Thread.currentThread().getName());
        Thread thread1 = new Thread(() -> {
            //System.out.println(Thread.currentThread().getName() + " - calling produce method");
            sharedResource.produce(lock, Thread.currentThread().getName());
        });

        Thread thread2 = new Thread(() -> {
            //System.out.println(Thread.currentThread().getName() + " - calling produce method");
            sharedResource.produce(lock, Thread.currentThread().getName());
        });
        SharedResource sharedResource1 = new SharedResource();
        Thread thread3 = new Thread(()-> {
            //System.out.println(Thread.currentThread().getName() + " - calling write method");
            sharedResource1.writeData(lock, Thread.currentThread().getName());
        });
        thread1.start();
        thread2.start();
        thread3.start();

        try{
//            thread1.join();
//            thread2.join();
//            thread3.join();
        }catch (Exception e){

        }

        System.out.println("Ended - " + Thread.currentThread().getName());
        System.out.println("Time ended - " + LocalDateTime.now());
    }
}
