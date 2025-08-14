package org.example.multithreading2.basics;

import org.example.oops.ConstructorDemo;

import java.util.concurrent.locks.ReentrantLock;

public class UnderstandSynchronisation {
    static int sharedCounter = 0;

    Object o = new Object();

    // Synchronized method to increment once
    public synchronized int incCounter(String t) {
        System.out.println("entereted - " + t);
        return ++sharedCounter;

    }


    // Synchronized method to loop and increment
    public synchronized int startLoop() {
        for (int i = 0; i < 10_000; i++) {
            sharedCounter++;
        }
        return sharedCounter;
    }

    public static void main(String[] args) throws InterruptedException {
        UnderstandSynchronisation a = new UnderstandSynchronisation();

        Thread t1 = new Thread(() -> {
            System.out.println("By t1 - sharedCounter value - " + sharedCounter);
            a.incCounter("t1");
            System.out.println("By t1 - called incCounter - " + sharedCounter);
        });

        Thread t3 = new Thread(() -> {
            System.out.println("By t3 - sharedCounter value - " + sharedCounter);
            a.startLoop();
            System.out.println("By t3 - after loop - " + sharedCounter);
        });

        Runnable r = null;
        Thread t2 =new Thread(() -> {
            System.out.println("By t2 - sharedCounter value - " + sharedCounter);
            a.incCounter("t2");
            System.out.println("By t2 - called incCounter - " + sharedCounter);
        });


        // Start in desired order with joins
        t1.start();
        t2.start();
        //t1.join(); // wait until t1 completes

        t3.start();
        //t3.join(); // wait until t3 completes


        //t2.join(); // wait until t2 completes

        System.out.println("Final sharedCounter = " + sharedCounter); // should be 10002
    }
}
