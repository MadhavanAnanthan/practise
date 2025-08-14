package org.example.multithreading2.basics;

public class LivelockRestaurant {

    static class Bill {
        private volatile boolean isPaid = false;
    }

    static class Neighbor {
        private final String name;
        private boolean polite = true;

        public Neighbor(String name) {
            this.name = name;
        }

        public void payBill(Bill bill, Neighbor other) {
            while (!bill.isPaid) {
                if (polite) {
                    System.out.println(name + ": No no, " + other.name + " you go ahead and pay.");
                    try {
                        Thread.sleep(100); // Simulate hesitation
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    if (!bill.isPaid) {
                        System.out.println(name + ": Okay, I'm paying the bill now. 💳");
                        bill.isPaid = true;
                    }
                }

                // Change behavior to reflect what other person is doing
                polite = other.polite;
            }
        }
    }

    public static void main(String[] args) {
        final Bill bill = new Bill();

        final Neighbor neighborA = new Neighbor("NeighborA");
        final Neighbor neighborB = new Neighbor("NeighborB");

        Thread t1 = new Thread(() -> neighborA.payBill(bill, neighborB));
        Thread t2 = new Thread(() -> neighborB.payBill(bill, neighborA));

        t1.start();
        t2.start();
    }
}



