package org.example.concurrency;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Restaurant {
    private final Semaphore tables;

    public Restaurant(int tableCount) {
        this.tables = new Semaphore(tableCount);
    }

    public void dineIn(int customerId) {
        try {
            System.out.println("Customer " + customerId + " waiting for table...");
            tables.acquire(); // Block until table available
            System.out.println("Customer " + customerId + " got a table!");

            // Simulate dining
           // Thread.sleep(2000);

            System.out.println("Customer " + customerId + " finished dining");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            tables.release(); // Always release the permit
        }
    }


    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(1);
        //queue.put("abc");
        queue.put(null);

        System.out.println(queue.take());
        Restaurant restaurant = new Restaurant(1); // 3 tables available

// Create 5 customers
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(()->{
                restaurant.dineIn(finalI);
            }).start();
        }
    }
}
// Usage

