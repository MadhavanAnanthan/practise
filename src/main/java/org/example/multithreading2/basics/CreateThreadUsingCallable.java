package org.example.multithreading2.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CreateThreadUsingCallable {

    public static void main(String[] args) throws InterruptedException {

        Callable<String> call = () -> {
            return "From callable";
        };

        new Thread();

        List<Callable<String>> callList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            callList.add(() -> {
                return "List - ";
            });
        }


        ExecutorService executorService = Executors.newFixedThreadPool(101);
        //List<Future<String>> submit = executorService.submit(callList);
        List<Future<String>> submit = executorService.invokeAll(callList);
        try {
            for (Future<String> s : submit)

                System.out.println(s.get());

        } catch (ExecutionException ex) {
            throw new RuntimeException(ex);
        }

//executorService.shutdown();
    }
}
