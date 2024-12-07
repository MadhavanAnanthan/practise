package org.example.multithreading.atomic;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        System.out.println("Time start - " + LocalDateTime.now());

        // This is the common shared resource to maintain thread safe as well as no locking mechanism
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(100);

        System.out.println("Current thread - " + Thread.currentThread().getName());

        // Below thread will insert 0 to 49 numbers into the shared resource
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " - calling produce method");
            int i=0;
            while(i<50) {
                atomicIntegerArray.getAndSet(i,i);
                i++;
            }
            // it will print the array, but we can;t expect only 0 to 49 numbers
            // becuase thread2 might insert 50 to 99 numbers.

            // But we can expect the right order even though we are not using lock based concurrency,
            // becuase Atomic used to achive this without locking
            System.out.println(atomicIntegerArray);
        });
        // Below thread will insert 50 to 99 numbers into the shared resource
        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " - calling produce method");
            int i=50;
            while(i<100) {
                atomicIntegerArray.getAndSet(i,i);
                i++;
            }
            System.out.println(atomicIntegerArray);
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
