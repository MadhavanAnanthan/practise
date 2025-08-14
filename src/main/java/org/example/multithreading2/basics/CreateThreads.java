package org.example.multithreading2.basics;

import java.lang.management.MonitorInfo;

public class CreateThreads  {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("started");

        Runnable runnableForT1 = () -> {
            synchronized (CreateThreads.class){
                System.out.println("t1: running and waiting...");
                try {
                    CreateThreads.class.wait();
                    System.out.println("t1: resumed after notify");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t1 = new Thread(runnableForT1);
        System.out.println("started creating t1 thread - " + t1.getState());
        t1.start();
       // Thread.sleep(2000);

        Thread t2 = new Thread(
            ()->{
                synchronized (CreateThreads.class){

                    CreateThreads.class.notify();
                    System.out.println("t2 thread started, notifying to t1 - ");
                }
            }
        );

        t2.start();
        //t2.join();
       // Thread.sleep(100);
        System.out.println("t1 state after notify: " + t1.getState());
        //t1.join();
        System.out.println("t1 final state: " + t1.getState());

        System.out.println("Main ended");
    }

}
