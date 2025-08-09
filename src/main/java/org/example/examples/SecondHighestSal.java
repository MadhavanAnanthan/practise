package org.example.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SecondHighestSal {
    public static void main(String[] args) {
        List<Integer> saleries = Arrays.asList(2000, 3000, 1000, 5000);

saleries.stream().sorted().collect(Collectors.toList()).reversed().stream().skip(1).findFirst().ifPresent(i-> System.out.println(i));

    }
}
