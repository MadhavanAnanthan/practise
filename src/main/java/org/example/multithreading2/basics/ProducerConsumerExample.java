package org.example.multithreading2.basics;

public class ProducerConsumerExample {

    static boolean foodIsReady = false;
    static Object monitorLock = ProducerConsumerExample.class;

    public static void main(String[] args) throws InterruptedException {

        Runnable pickupRunnable = ()->{
            synchronized (monitorLock) {
                while (!foodIsReady) {
                    try {
                        monitorLock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Pickup person picked up the food");
            }
        };

        Runnable foodRunnable = ()->{
            synchronized (monitorLock) {
                foodIsReady = true;
                System.out.println("Food is ready to pickup");
                monitorLock.notify();
            }
        };
        Thread restaurant = new Thread(foodRunnable);
        restaurant.start();
        Thread pickupPersonThread = new Thread(pickupRunnable);
        pickupPersonThread.start();
    }
}
