package org.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Problem26 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 75000),
            new Employee("Bob", 80000),
            new Employee("Charlie", 95000),
            new Employee("Alice", 90000), // Duplicate key
            new Employee("David", 60000)
        );
        TreeMap<String, Double> employeeTreeMap = new TreeMap();
        employees.stream().filter(e-> !employeeTreeMap.containsKey(e.getName())).forEach(e->{
            employeeTreeMap.put(e.getName(), e.getSalary());
        });
        System.out.println(employeeTreeMap);
    }

    static public class Employee {
        private String name;
        private double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }
    }

}
