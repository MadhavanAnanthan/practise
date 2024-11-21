package org.example.multithreading;

public class ProducerThread implements Runnable{

    SharedResource sharedResource;

    ProducerThread(SharedResource sharedResource){
        this.sharedResource=sharedResource;
    }


    @Override
    public void run() {
        sharedResource.addItem();
    }
}
