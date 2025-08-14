package org.example.testing;

import java.util.*;
import java.util.stream.Collectors;

public class Fiserv {

    public static void main(String[] args) {


        List<Employee> employeeList = new ArrayList<>();
        employeeList.stream().max(Fiserv::getSalary).ifPresent(System.out::println);

        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst();

        // Map
        Map<String, Integer> employeeMap = new HashMap<>();
        employeeList.stream().forEach(e-> {
            employeeMap.put(e.getName(), employeeMap.getOrDefault(e,0)+1);
        });

        for(Map.Entry<String, Integer> employeeInsance :employeeMap.entrySet()){
            if(employeeInsance.getValue()>1){
                System.out.println(employeeInsance.getKey());
            }
        }



    }

    private static int getSalary(Employee employee, Employee employee1) {
        return Integer.compare( (int) employee1.getSalary(),(int) employee.getSalary());
    }




    public static class Employee {

        private int id;

        private String name;

        private String department;

        private double salary;

        private int age;

        public int getId() {
            return id;
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

        public int getAge() {
            return age;
        }
// getters, setters, constructors


    }

}
