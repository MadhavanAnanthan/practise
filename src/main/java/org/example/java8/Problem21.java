package org.example.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Problem21 {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "IT", 70000),
            new Employee("Bob", "Finance", 80000),
            new Employee("Charlie", "IT", 75000),
            new Employee("David", "HR", 50000),
            new Employee("Eva", "Finance", 90000)
        );

        HashMap<String, Double> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, HashMap::new, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect);


    }

    static class Employee {
        private String name;
        private String department;
        private double salary;

        public Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }
    }

}
