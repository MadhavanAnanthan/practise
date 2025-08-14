package org.example.examples;
import java.util.*;
import java.util.stream.Collectors;

public class PartitionAListOfIntegerIntoEvenAndOdd {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Map<Boolean, List<Integer>> booleanListMap = numbers.stream().collect(Collectors.partitioningBy(PartitionAListOfIntegerIntoEvenAndOdd::isEven));
        System.out.println("even"+ booleanListMap.get(true));
        System.out.println("odd"+ booleanListMap.get(false));
    }

    private static boolean isEven(Integer integer) {
        if(integer%2==0){
            return true;
        }
        return false;
    }
}
