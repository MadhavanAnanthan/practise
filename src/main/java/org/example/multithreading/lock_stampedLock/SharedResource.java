package org.example.multithreading.lock_stampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    StampedLock stampedLock = new StampedLock();
int valueFromDB = 10;
    public void consume(String threadName) {
        long state = stampedLock.tryOptimisticRead();
        System.out.println("Locked by thread - " + threadName);
        try{
            valueFromDB=11;
            Thread.sleep(4000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(stampedLock.validate(state)){
            System.out.println("No change in resource" + threadName);
        }else{
            valueFromDB=10;
            System.out.println("Rollback the changes");
        }
    }

    public void produce(String threadName){
        System.out.println("Thread is ready to write");
        long writeState = stampedLock.writeLock();
        // changing common resource
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        stampedLock.unlockWrite(writeState);
        System.out.println("Thread write is successful");
    }
}
