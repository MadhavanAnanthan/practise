package org.example.multithreading2.basics;

public class ProducerConsumerDeadlockExample {
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();
    public static void main(String[] args) {

        Runnable pickupRunnable = ()->{
            synchronized (lock1){
                System.out.println("Pickup thread acquired lock 1, trying to get lock2");
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    throw  new RuntimeException();
                }
                synchronized (lock2){
                    System.out.println("Already Restaurant thread locks lock2");
                }
            }
        };

        Runnable foodRunnable = ()->{
            synchronized (lock2){
                System.out.println("Restaurant thread acquired lock2, trying to get lock1...");
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    throw new RuntimeException();
                }
                synchronized (lock1){
                    System.out.println("Already Pickup thread acquired lock 1");
                }
            }
        };
        new Thread(pickupRunnable).start();
        new Thread(foodRunnable).start();
    }
}
