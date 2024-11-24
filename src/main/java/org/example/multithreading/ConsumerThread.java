package org.example.multithreading;

public class ConsumerThread implements  Runnable{

    SharedResource sharedResource;

    ConsumerThread(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.consumeItem();
    }
}
