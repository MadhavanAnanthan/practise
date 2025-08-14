package org.example.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {

    ReentrantLock reentrantLock = new ReentrantLock();

    void tryToOpenPasswordProtectedFile(){
        reentrantLock.lock();
        try {
            System.out.println("Try to opening a file");
            enterPasswordAndOpenFile();
        }finally {
            reentrantLock.unlock();
        }

    }

    void enterPasswordAndOpenFile(){
        reentrantLock.lock();
        try {
            System.out.println("Enter password and open the file");
        }finally {
            reentrantLock.unlock();
        }
    }
    public static void main(String[] args) {
        ReentrantExample reentrantExample = new ReentrantExample();
        reentrantExample.tryToOpenPasswordProtectedFile();
    }
}
