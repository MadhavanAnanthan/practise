package org.example.multithreading.lock_readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    public void produce(ReadWriteLock readWriteLock, String threadName) {

        System.out.println("Locked by thread - " + threadName);
        try{
            readWriteLock.readLock().lock();
            Thread.sleep(4000);
        }catch (Exception e){

        }
        finally {
            readWriteLock.readLock().unlock();
            System.out.println("Un-Locked by thread - " + threadName);
        }
    }

    public void writeData(ReadWriteLock readWriteLock, String threadName) {
        try{
            readWriteLock.writeLock().lock();
            System.out.println("Write Locked by thread - " + threadName);
            //Thread.sleep(1000);
        }catch (Exception e){

        }finally {
            readWriteLock.writeLock().unlock();
            System.out.println("Write Un-Locked by thread - " + threadName);
        }
    }
}
