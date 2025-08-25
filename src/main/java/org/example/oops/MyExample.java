package org.example.oops;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyExample {

    public static void main(String[] args) {
        List<Integer> saleries = Arrays.asList(2000, 3000, 1000, 5000);

        saleries.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresentOrElse(salary -> System.out.println(salary) , ()-> System.out.println("not found"));
        System.out.println("hello");
    }
}
