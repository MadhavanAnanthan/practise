package org.example.multithreading2.basics;

public class CreateThreadUsingThreadClassAndRunnable {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 executed");
            }
        });

        Runnable runnable = () ->{
            System.out.println("Thread 2 executed");
        };

        thread.start();
        new Thread(runnable).start();
    }
}
