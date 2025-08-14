package org.example.examples;

import java.util.*;

public class SecondHighestSalary {
    public static void main(String[] args) {
        String input = "swiss";

        char [] split = input.toCharArray();
        List<Character> characters = new ArrayList<>();
        for(char c : split){
            characters.add(c);
        }

        Map<Character, Integer> countMap = new LinkedHashMap<>();

        characters.stream().forEach(c-> {
            countMap.put(c, countMap.getOrDefault(c , 0) +1);
        });

//        LinkedHashMap<Character, Long> collect = characters.stream()
//            .collect(Collectors.groupingBy
//                (Function.identity(), LinkedHashMap::new,
//                    Collectors.counting()));
//        System.out.println(collect);

            countMap.entrySet().stream().filter(e -> e.getValue() == 1).findFirst().ifPresent(e-> System.out.println(e.getKey()));




    }
}
