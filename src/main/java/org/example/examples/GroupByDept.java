package org.example.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByDept {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        Map<String, List<Employee>> listMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.toList()));
        System.out.println(listMap);
    }

    class Employee{
        int id;
        String name;
        String dept;

        String getName(){
            return name;
        }
        String getDept(){
            return dept;
        }
        int getId(){
            return id;
        }
    }
}
