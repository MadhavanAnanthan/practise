package org.example.examples;

@FunctionalInterface
interface MyInterface {
    void run(String s); // only abstract method

    default void log(String msg) { // default implementation
        System.out.println("Log: " + msg);
    }

    static void info() { // static method
        System.out.println("Static info method");
    }
}

