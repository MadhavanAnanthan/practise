package org.example.examples;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Comparing  {
    public static void main(String[] args) {
        List<Employee1> employees = Arrays.asList(
            new Employee1(3, "Alice", 50000),
            new Employee1(1, "Bob", 60000),
            new Employee1(2, "Charlie", 55000)
        );

        Collections.sort(employees);
        List<Employee1> collect = employees.stream().sorted(Comparator.comparing(Employee1::getId)).collect(Collectors.toList());
        collect.stream().forEach(e-> System.out.println(e));

        employees.stream()
            .sorted(Comparator.comparingDouble((Employee1 e) -> e.salary).reversed())
            .forEach(System.out::println);
    }
}

    class Employee1 implements Comparable<Employee1>{
        int id;
        String name;
        double salary;

        Employee1(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public int compareTo(Employee1 o) {
            return Integer.compare(this.id, o.id);
        }

        @Override
        public String toString() {
            return "Employee1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
        }
    }
