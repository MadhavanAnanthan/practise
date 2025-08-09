package org.example.multithreading2.basics;

public class StarvationRealWorld {

    static class SharedTask {
        public synchronized void perform(String name) {
            System.out.println(name + " is performing the task");
        }
    }

    public static void main(String[] args) {
        SharedTask task = new SharedTask();

        // Greedy thread (imagine a scheduled job running frequently)
        Thread greedyThread = new Thread(() -> {
            while (true) {
                task.perform("🔁 FrequentJob");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        // Normal user threads - simulate end users
        Runnable userTask = () -> {
            String name = Thread.currentThread().getName();
            while (true) {
                task.perform("User " + name);
                try {
                    Thread.sleep(1000); // Wait before trying again
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread user1 = new Thread(userTask, "User-1");
        Thread user2 = new Thread(userTask, "User-2");

        greedyThread.start();
        user1.start();
        user2.start();
    }
}
