package org.example.multithreading;

public class SharedResource {

    boolean isItemAvailable = false;

    public synchronized void  addItem(){
        System.out.println("Producer thread called addItem");
        isItemAvailable=true;
        try {
            System.out.println("Producer thread is sleeping for 5 secs");
            Thread.sleep(5000L);
            System.out.println("Producer thread awakes");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notifyAll();
        System.out.println("Notify called from producer");
    }

    public synchronized void consumeItem(){
        System.out.println("Consumer thread inside consumeItem function");
        while(!isItemAvailable){
            try {
                System.out.println("Consumer thread is waiting");
                wait();
                System.out.println("Got notification from Producer thread");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        isItemAvailable=false;
    }
}
