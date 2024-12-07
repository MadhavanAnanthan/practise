package org.example.multithreading.lock_reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    public void produce(ReentrantLock reentrantLock, String threadName) {
        reentrantLock.lock();
        System.out.println("Locked by thread - " + threadName);
        try{
            Thread.sleep(4000);
        }catch (Exception e){

        }
        reentrantLock.unlock();
        System.out.println("Un-Locked by thread - " + threadName);
    }
}
