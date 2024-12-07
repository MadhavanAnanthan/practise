package org.example.multithreading.understand_synchronized_keyword;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        System.out.println("Time start - " + LocalDateTime.now());

        SharedResource sharedResource = new SharedResource();
        SharedResource sharedResource1 = new SharedResource();
        SharedResource sharedResource2 = new SharedResource();

        System.out.println("Current thread - " + Thread.currentThread().getName());
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " - calling produce method");
            sharedResource.produce(Thread.currentThread().getName());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " - calling produce method");
            sharedResource.produce(Thread.currentThread().getName());
        });

        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " - calling produce method");
            sharedResource.produce(Thread.currentThread().getName());
        });


        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();thread3.join();

        } catch (Exception e) {

        }
        System.out.println("Ended - " + Thread.currentThread().getName());
        System.out.println("Time ended - " + LocalDateTime.now());
    }
}
