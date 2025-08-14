package org.example.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Top3StudentsBasedOnScore {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        studentList.stream().sorted(Comparator.comparingInt(Student::getScore).reversed()).limit(3).map(Student::getName).forEach(System.out::println);



    }

    class Student{
        String name;
        int score;
        int getScore(){
            return score;
        }
        String getName(){
            return name;
        }
    }
}
