package org.example.examples;

import java.util.*;
import java.util.stream.Collectors;

public class CountFrequencyOfEachWordInASentence {

    public static void main(String[] args) {

        String sentence = "hello world hello hello java";
        String[] split = sentence.split(" ");
        List<String> stringList = Arrays.asList(split);
        Map<String, Integer> objectObjectHashMap = new HashMap<>();
        stringList.stream().forEach(e->{
            objectObjectHashMap.put(e, objectObjectHashMap.getOrDefault(e , 0) + 1);
        });
        System.out.println(objectObjectHashMap);
    }
}
