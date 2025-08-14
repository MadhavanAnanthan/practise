package org.example.examples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

public class FlattenAListOfLIstsAndRemoveDuplicates {
    public static void main(String[] args) {

        List<List<Integer>> numbers = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(3, 4, 5),
            Arrays.asList(5, 6)
        );
        // 1
        numbers.stream().flatMap(List::stream).distinct().collect(Collectors.toList());

        // 2
        Set<Integer> collectFinal = new HashSet<>();
        for(int i=0; i<numbers.size(); i++) {
            List<Integer> indiList = numbers.get(i);
            Set<Integer> collect1 = indiList.stream().collect(Collectors.toSet());
            collectFinal.addAll(collect1);
        }

        System.out.println(collectFinal);

        // 3
        List<Integer> collect = numbers.stream()
            .flatMap(Collection::stream).distinct().collect(Collectors.toList());
    }
}
