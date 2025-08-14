package org.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem28 {

    public static void main(String[] args) {

        // The specific customerId we are interested in
        String targetCustomerId = "customerA";
        // Create a list of Order objects
        List<Order> orders = Arrays.asList(
            new Order("customerA", Arrays.asList(new Item("Laptop", 1200.0), new Item("Mouse", 25.0))),
            new Order("customerB", Arrays.asList(new Item("Keyboard", 75.0), new Item("Monitor", 300.0))),
            new Order("customerA", Arrays.asList(new Item("Mouse", 25.0), new Item("Headphones", 150.0))),
            new Order("customerC", Arrays.asList(new Item("Webcam", 50.0))),
            new Order("customerA", Arrays.asList(new Item("Laptop", 1200.0), new Item("External HDD", 80.0)))
        );

        Set<String> collect = orders.stream().filter(order -> order.customerId.equals(targetCustomerId))
            .flatMap(order -> order.getItems().stream())
            .map(Item::getName)
            .collect(Collectors.toSet());
        System.out.println(collect);


    }

    // Define the Item class
    static class Item {
        String name;
        double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }
    }

    // Define the Order class
    static class Order {
        String customerId;
        List<Item> items;

        public Order(String customerId, List<Item> items) {
            this.customerId = customerId;
            this.items = items;
        }

        public String getCustomerId() {
            return customerId;
        }

        public List<Item> getItems() {
            return items;
        }

        @Override
        public String toString() {
            return "Order{" +
                "customerId='" + customerId + '\'' +
                ", items=" + items +
                '}';
        }
    }


}
