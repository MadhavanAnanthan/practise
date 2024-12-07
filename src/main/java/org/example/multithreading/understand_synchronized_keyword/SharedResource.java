package org.example.multithreading.understand_synchronized_keyword;

public class SharedResource {

    public synchronized void produce(String threadName) {
        System.out.println("Entered thread -" + threadName);
        try{
            Thread.sleep(5000);
        }catch (Exception e){

        }
        System.out.println("Ended thread -" + threadName);
    }

    public void produce1(String name) {
        System.out.println("Entered thread -" + name);
        try{
            Thread.sleep(10000);
        }catch (Exception e){

        }
        System.out.println("Ended thread -" + name);
    }
}
