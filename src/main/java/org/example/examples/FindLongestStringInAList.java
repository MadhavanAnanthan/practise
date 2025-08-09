package org.example.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindLongestStringInAList {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "SpringBoot", "Microservices", "REST");
        words.stream().max(Comparator.comparingInt(String::length)).ifPresent(System.out::println);
    }
}
