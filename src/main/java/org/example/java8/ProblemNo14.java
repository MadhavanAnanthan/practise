package org.example.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemNo14 {
    public static void main(String[] args) {

        // 14. two arrays of Person objects, merge them, sort them by age in ascending order,
        // and then by name alphabetically for people with the same age
        List<Person> personList1 = new ArrayList<>();
        personList1.add(new Person("John", 25));
        Person p2 = new Person("Alice", 22);
        personList1.add(p2);

        List<Person> personList2 = new ArrayList<>();
        personList2.add(new Person("Bob", 25));
        personList2.add(new Person("Charlie", 30));
        personList2.add(new Person("Anna", 22));

        // merging them

        personList1.addAll(personList2);

        List<Person> sortedAge = personList1.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName)).collect(Collectors.toList());

        sortedAge.forEach(p -> {
            System.out.println("Age - " + p.getAge() + "," + "Name - " + p.getName());
        });
    }

    static class Person {
        String name;
        int age;


        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }
}

