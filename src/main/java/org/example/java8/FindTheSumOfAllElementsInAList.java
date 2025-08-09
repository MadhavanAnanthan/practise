package org.example.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindTheSumOfAllElementsInAList {

    public static void main(String[] args) {


        // 1. FindTheSumOfAllElementsInAList
        IntStream stream = Arrays.stream(new int[]{1, 0, 3, 0, 6, 67, 8, 8, 8, 9});
        System.out.println(stream.sum());


        // 2. find and print the maximum element
        IntStream streamMax = Arrays.stream(new int[]{1, 0, 3, 0, 6, 67, 8, 8, 8, 9});
        System.out.println(streamMax.max());

        // 3. print even numbers alone
        List<Integer> list = Arrays.asList(1, 0, 3, 0, 6, 67, 8, 8, 8, 9);
        Map<Boolean, List<Integer>> booleanListMap = list.stream().collect(Collectors.partitioningBy(FindTheSumOfAllElementsInAList::isEven));
        System.out.println("Even " + booleanListMap.get(true));

        // 4. count the number of strings containing a specific character ‘a’
        List<String> words = Arrays.asList("apple", "hdfej", "has", "hen");
        long containsA = words.stream().filter(word -> word.contains("a")).count();

        // 5. convert a list of strings to uppercase
        words.stream().map(e -> e.toUpperCase()).collect(Collectors.toList());

        // 6. calculate the average of all the numbers
        list.stream().collect(Collectors.averagingDouble(Integer::doubleValue));

        // 7. sort a list of strings in alphabetical order
        words.stream().sorted().collect(Collectors.toList());

        // 8. concatenate all the strings
        List<String> words1 = Arrays.asList("apple", "hdfej", "has", "hen");
        words1.stream().collect(Collectors.joining());

        // 9. find the longest string in a list of strings
        String s = words.stream().max(FindTheSumOfAllElementsInAList::findStringLenght).get();
        System.out.println(s);

        // 9.1 find the second longest string in a list of strings
        words.stream().sorted(FindTheSumOfAllElementsInAList::findStringLengthInDesc).skip(1).findFirst().get();

        // 10. find and print the second largest number
        List<Integer> list1 = Arrays.asList(1, 0, 3, 6, 67, 8, 9);
        System.out.println(list1.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().get());

        // 11.  remove all the duplicate elements from a list
        List<Integer> containsDuplicates = Arrays.asList(1, 0, 3, 0, 6, 67, 8, 8, 8, 9);
        List<Integer> result = containsDuplicates.stream().distinct().collect(Collectors.toList());
        System.out.println(result);

        // 12.find the Maximum element in an array
        List<Integer> list3 = Arrays.asList(1, 0, 3, 0, 6, 67, 8, 8, 8, 9);
        Integer maxValue = list3.stream().max(Integer::compare).get();
        System.out.println(maxValue);

        // 13. print the count of each character in a String
        String word2 = "apple orange";
        Map<Character, Long> countsForWords = word2.chars().mapToObj(c -> (char) c).filter(c -> c != ' ').collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        countsForWords.forEach((k, v) -> {
            System.out.println("Key - " + k + "," + "Value - " + v);
        });

        // 14. two arrays of Person objects, merge them, sort them by age in ascending order,
        // and then by name alphabetically for people with the same age

        // Refer -> ProblemNo14.java

        // 15. find the length of the longest name in a list of strings
        List<String> words3 = Arrays.asList("apple", "hdfejev", "has", "hen");
        //int length = words3.stream().sorted(FindTheSumOfAllElementsInAList::findStringLengthInDesc).findFirst().get().toCharArray().length;
        int length = words3.stream().mapToInt(String::length).max().orElse(0);
        System.out.println(length);

        // 16. list of integers contains any prime numbers
        List<Integer> checkPrime = Arrays.asList(1, 0, 3, 0, 6, 67, 8, 8, 8, 9);
        checkPrime.stream().filter(FindTheSumOfAllElementsInAList::isPrime).findFirst().ifPresent(e -> System.out.println(e + " - is the prime number"));

        // 17. Count the total number of distinct words (case-insensitive) across multiple sentences

        List<String> sentences = Arrays.asList(
            "Hello world",
            "hello Java",
            "Java stream API is powerful",
            "world of code"
        ); // 6
        sentences.stream().map(String::toLowerCase).flatMap(str -> Arrays.stream(str.split(" "))).distinct().count();

        // 18. Find and concatenate the first two words that have even lengths
        String str = "hello my name is madhavan, how about you";
        String resultString = Arrays.stream(str.split(" ")).filter(str2 -> str2.length() % 2 == 0).limit(2).collect(Collectors.joining());
        System.out.println(resultString);

        // 19. Given a list of transactions, find the sum of transaction amounts for each day and sort by date
        // Refer -> Problem no 19

        //20. Given two arrays of integers, merge them, sort them, and then filter out any numbers greater than a specified threshold
        int[] arr1 = {3, 15, 7, 1};
        int[] arr2 = {10, 2, 18, 5};
        int threshold = 10;
        int[] array = Stream.of(arr1, arr2).flatMapToInt(Arrays::stream).toArray();

        List<Integer> collect = Arrays.stream(array).sorted().filter(n -> n <= threshold).boxed().collect(Collectors.toList());
        System.out.println(collect);


        // 21. Transform a list of employee records into a map of department to average salary using Stream API.

        // Refer -> Problem21

        // 22. partition into prime and non prime
        List<Integer> checkPrime1 = Arrays.asList(1, 0, 3, 0, 6, 67, 8, 8, 8, 9);
        checkPrime1.stream().collect(Collectors.partitioningBy(FindTheSumOfAllElementsInAList::isPrime));

        // 23. Generate Fibonacci sequence up to n terms using streams.
        // Refer -> Problem23

        // 24. Group strings by their first character and count occurrences using Stream API.
        List<String> stringList = Arrays.asList("apple", "apricot", "banana", "blueberry", "avocado", "cat", "dog");
        HashMap<Character, Long> characterLongHashMap = stringList.stream().collect(Collectors.groupingBy(e -> e.toCharArray()[0], HashMap::new, Collectors.counting()));

        // 25. Find the intersection of two lists using Java streams.
        List<String> nameList1 = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> nameList2 = Arrays.asList("Charlie", "David", "Alice");
        nameList2.stream().filter(nameList1::contains).collect(Collectors.toSet());

        // 26.
        // Refer -> Problem26
    }

    private static int findStringLengthInDesc(String s1, String s2) {
        // option 1
        // return Integer.compare(s2.length(), s1.length());
        // option 2
        if(s2.length() > s1.length()){
            return 1;
        }
        else if(s1.length()==(s2.length())) {
            return 0;
        }
        else  {
            return -1;
        }
    }

    private static int findStringLenght(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }

    private static boolean isEven(Integer integer) {
        return integer%2==0;
    }

    private static boolean isPrime(Integer number){
        if(number<=1) return false;
        for(int i=2;i<number; i++){
            if(number%i==0)
                return false;
        }
        return true;
    }

}
