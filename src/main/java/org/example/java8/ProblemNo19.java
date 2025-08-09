package org.example.java8;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ProblemNo19 {
    public static void main(String[] args) {

        List<Transaction> transactions =
        Arrays.asList(
            new Transaction(LocalDate.of(2025, 8, 1), 150.0),
            new Transaction(LocalDate.of(2025, 8, 1), 200.0),
            new Transaction(LocalDate.of(2025, 8, 3), 90.0),
            new Transaction(LocalDate.of(2025, 8, 2), 300.0),
            new Transaction(LocalDate.of(2025, 8, 3), 50.0)
        );

        TreeMap<LocalDate, Double> map = transactions.stream().collect(Collectors.groupingBy(Transaction::getDate, TreeMap::new, Collectors.averagingDouble(Transaction::getAmount)));
        System.out.println(map);
    }


    public static class Transaction {
        private LocalDate date;
        private double amount;

        public Transaction(LocalDate date, double amount) {
            this.date = date;
            this.amount = amount;
        }

        public LocalDate getDate() {
            return date;
        }

        public double getAmount() {
            return amount;
        }

    }

}
