package org.example.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem30 {
    public static void main(String[] args) {
        // Define the Map with categories as keys and lists of items as values
        Map<String, List<String>> categorizedItems = new HashMap<>();

        // Populate the map with sample data
        categorizedItems.put("Fruits", Arrays.asList("Apple", "Banana", "Orange"));
        categorizedItems.put("Vegetables", Arrays.asList("Carrot", "Broccoli", "Spinach"));
        categorizedItems.put("Dairy", Arrays.asList("Milk", "Cheese"));
        categorizedItems.put("Grains", Arrays.asList("Rice", "Bread", "Pasta"));

        // This `categorizedItems` map is the input for your stream pipeline.
        System.out.println("Input Map: " + categorizedItems);


        List<String> collect = categorizedItems.entrySet().stream().map(Map.Entry::getValue).flatMap(List::stream).collect(Collectors.toList());
        System.out.println(collect);
    }
}
