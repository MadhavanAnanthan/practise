package org.example.multithreading2.basics;

public class RaceConditionExample {
   // static Object lock = new Object();
    static int availableQuantity = 1;

    static class UserA extends Thread {
        @Override
        public void run() {
            if (availableQuantity >= 1){
               // synchronized (lock) {
                System.out.println("Bought by userA, available quantity is - " + --availableQuantity);
                //}
            }
        }
    }

    static class UserB implements Runnable {
        @Override
        public void run() {
            if (availableQuantity >= 1) {
                // synchronized (lock) {
                System.out.println("Bought by userB, available quantity is - " + --availableQuantity);
                //}
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new UserA();          // Thread-1
        Thread t2 = new Thread(new UserB()); // Thread-2
        t1.start();
        t2.start();
    }
}
