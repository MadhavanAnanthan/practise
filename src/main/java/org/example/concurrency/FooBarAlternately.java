package org.example.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Semaphore;

public class FooBarAlternately {

    static final Semaphore lock = new Semaphore(1);
    static final Semaphore barLock = new Semaphore(0);

    static void fooMessage() {
        System.out.print("Foo ");
        barLock.release();
    }

    static void barMessage() throws InterruptedException {
        barLock.acquire();
        System.out.print(" Bar");
        lock.release();
    }


    public static void main(String[] args) throws InterruptedException {

        ForkJoinPool forkJoinPool = new ForkJoinPool();


        for (int i = 0; i < 3; i++) {
    Thread.sleep(100000);
            forkJoinPool.submit(() ->
                {
                    try {
                        lock.acquire();
                        fooMessage();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            );

            forkJoinPool.submit(() -> {
                try {
                    barMessage();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        //forkJoinPool.shutdown();
    }
}
