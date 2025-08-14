package org.example.concurrency;

public class SynError {

    synchronized void transfer(){
        System.out.println("enteretd transfer");
        validate();
    }

    synchronized void validate(){
        System.out.println("enteretd valdiate");
    }
    public static void main(String[] args) {
        SynError sync = new SynError();
        synchronized (sync){
            sync.transfer();
            synchronized (sync){
                sync.validate();
            }
        }


    }
}
