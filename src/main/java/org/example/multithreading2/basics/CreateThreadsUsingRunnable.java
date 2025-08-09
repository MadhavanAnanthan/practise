package org.example.multithreading2.basics;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class CreateThreadsUsingRunnable {

    static int resource = 0;

    static synchronized int getResource() {
        return resource;
    }

    static final Object lock = CreateThreadsUsingRunnable.class;
    static boolean produced = false;

    public static void main(String[] args) {

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (!produced) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("resource val - " + getResource());
                }

            }
        };


//        Runnable producer = () -> resource = 10;
        Runnable producer = () -> {
            synchronized (lock) {
                resource = 10;
                produced = true;
                lock.notify();
            }

        };
        new Thread(consumer).start();
        new Thread(producer).start();


    }
}
