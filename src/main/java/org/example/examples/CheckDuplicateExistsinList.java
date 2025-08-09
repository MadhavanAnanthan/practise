package org.example.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckDuplicateExistsinList {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("sam", "anil","sunil");
        list.stream().filter(name->name.startsWith("s")).sorted().collect(Collectors.toList());

        List<Integer> saleries = Arrays.asList(2000, 3000, 1000, 5000, 20000);
// option 1

        boolean b = saleries.stream().distinct().count() < saleries.size();
        HashMap<Integer, Integer> counts = new HashMap<>();

        saleries.stream().forEach(s->{
            counts.put(s , counts.getOrDefault(s,0) + 1);
        });
        counts.entrySet().stream().filter(c->c.getValue()>1).findAny().ifPresent(c-> System.out.println("true"));
    }
}
