package org.example.concurrency;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteExample {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    private int sharedResource = 0;

    public void readData() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " reading: " + sharedResource);
        } finally {
            readLock.unlock();
        }
    }

    public void writeData(int value) {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " writing: " + value);
            sharedResource = value;
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteExample example = new ReadWriteExample();

        Runnable readTask = example::readData;
        Runnable writeTask = () -> example.writeData(42);

        // Start multiple read threads
        for (int i = 0; i < 300; i++) {
            new Thread(readTask, "Reader-" + i).start();
            new Thread(writeTask, "Writer").start();

        }
        // Start one write thread

    }
}

