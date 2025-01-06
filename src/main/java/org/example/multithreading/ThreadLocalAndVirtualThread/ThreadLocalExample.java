package org.example.multithreading.ThreadLocalAndVirtualThread;

public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        double sqrt = java.lang.Math.sqrt(10.0);
        Thread t1 = new Thread(() -> {
            threadLocal.set(10);
            System.out.println("Thread 1: " + threadLocal.get());
        });
        Thread t2 = new Thread(() -> {
            threadLocal.set(20);
            System.out.println("Thread 2: " + threadLocal.get());
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
