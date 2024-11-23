package org.example.multithreading.producer_consumer_prob;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {

    int bufferSize;
    private Queue<Integer> queue;

    public SharedBuffer(int bufferSize) {
        this.bufferSize = bufferSize;
        queue = new LinkedList<>();
    }

    public synchronized void produce(int item) {
        while (queue.size() == bufferSize) {
            System.out.println("Queue is full, wait for sometime to produce further");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.add(item);
        System.out.println("Produced item is -" + item);
        notify();
    }

    public synchronized int consume() {
        while (queue.isEmpty()) {
            System.out.println("Buffer is empty, consumer is waiting for producer to produce");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Integer consumedItem = queue.poll();
        System.out.println("Consumer consumed this item - " + consumedItem);
        // Notify producer to produce some item, because of some free space exists
        notify();
        return consumedItem;
    }
}
