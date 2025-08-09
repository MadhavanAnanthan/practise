package org.example.oops;

import java.util.Arrays;

public class ConstructorDemo {

    public static void main(String[] args) {

        Student[] stuArr = new Student[3];

        Student stu = new Student();
        System.out.println(stu.id);
        System.out.println(stu.name);
        Student stu1 = new Student(12, "shubvi");
        System.out.println(stu1);
        stuArr[0] = stu;
        stuArr[1] = stu1;
        System.out.println(Arrays.toString(stuArr));
    }
}
      class Student{
        Student(){

        }
        Student(int id1, String name1){
            id=id1;
            name=name1;
        }

        int id;
        String name;
    }

