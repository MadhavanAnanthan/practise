package org.example.examples;



import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindAverageSalaryOfItEmployeesEarningAbove50k_Q11 {



    public static void main(String[] args) {

        MyInterface a = (s)->{
            System.out.println("provided implmentation = "+ s);
        };

        Runnable run = ()->{
            System.out.println("provided implmentation");
        };

        Consumer<String> consumer = (s)->{
            System.out.println("provided implmentation = "+ s);
        };
        consumer.accept("abccc");
BiFunction<Integer, Integer, Integer> f = Integer::sum;
        Integer apply = f.apply(2, 3);

        run.run();

        a.run("hello");

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "IT", 50000));
        employees.add(new Employee("Bob", "Finance", 60000));
        employees.add(new Employee("Charlie", "IT", 70000));
        employees.add(new Employee("David", "HR", 40000));


        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Stream<Integer> sorted = numbers.stream().sorted();
        List<Integer> collect =  sorted.sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println(collect);

        System.out.println(
        employees.stream().filter(emp -> emp.getSalary() > 50000)
            .filter(Employee::isDeptIt)
            .collect(Collectors.averagingInt(e-> e.getSalary())).intValue()
        );
    }


}

class Employee {
    String name;
    String dept;
    int salary;


    Employee(String name, String dept, int salary){
        this.name=name;
        this.dept=dept;
        this.salary=salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String getDept() {
        return dept;
    }


    public boolean isDeptIt() {
        return dept.equals("IT");
    }
}
