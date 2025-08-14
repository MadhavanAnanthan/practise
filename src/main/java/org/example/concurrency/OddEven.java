package org.example.concurrency;

import java.util.concurrent.Semaphore;

public class OddEven {


    static int value =0;
    static Semaphore oddSemaphore = new Semaphore(1);
    static Semaphore evenSemaphore = new Semaphore(0);


    public static void main(String[] args) throws InterruptedException {
        // t1
        for(int i=0; i<100000;i++) {
            Runnable oddRunnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        oddSemaphore.acquire();
                        System.out.println("Thread 1 - " + ++value);
                        evenSemaphore.release();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    //oddSemaphore.release();
                }
            };
            new Thread(oddRunnable).start();



            // t2
            new Thread(() ->
            {
                try {
                    evenSemaphore.acquire();
                    System.out.println("Thread 2 - " + ++value);
                    oddSemaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();

        }
    }
}
