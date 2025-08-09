package org.example.examples;
import java.util.*;
public class SortAMapByItsValue {

    public static void main(String[] args) {
        Map<String, Integer> fruitCalories = new HashMap<>();
        fruitCalories.put("Apple", 95);
        fruitCalories.put("Banana", 105);
        fruitCalories.put("Orange", 62);

        fruitCalories.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(e-> System.out.println(e.getKey() +","+ e.getValue()) );






    }
}
