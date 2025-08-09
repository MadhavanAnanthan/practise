package org.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem23 {
    public static void main(String[] args) {

        // Imperative style
        List<Integer> fibanocci = generateFibonacci(3);
        // Declarative style
        fibanocci = generateFibonacciByStream(15);
        System.out.println(fibanocci);


    }

    private static List<Integer> generateFibonacciByStream(int i) {
        List<Integer> list = new ArrayList<>();
        IntStream.range(0,i).forEach(n-> {
            if(n<2){
                list.add(n);
            }else{
                list.add(n, list.get(n-1)+list.get(n-2));
            }
        });
        return list;
    }

    static List<Integer> generateFibonacci(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                list.add(i, i);
            } else {
                list.add(i, list.get(i - 1) + list.get(i - 2));
            }
        }
        return list;
    }

}
