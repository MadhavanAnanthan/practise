package org.example.multithreading.FixedThreadPoolExecutor;

import java.util.concurrent.*;

// RecursiveTask returns value
class SumTask extends RecursiveTask<Integer> {
    private final int[] numbers;
    private final int start;
    private final int end;

    public SumTask(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 4) {
            int sum = 0;
            System.out.println("printed if");
            for (int i = start; i <= end; i++) {
                sum += numbers[i];
            }
            return sum;
        } else {
            System.out.println("printed else");
            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(numbers, start, mid);
            SumTask rightTask = new SumTask(numbers, mid + 1, end);
            leftTask.fork();
            rightTask.fork();
            return leftTask.join() + rightTask.join();
        }
    }
}

public class ForkJoinExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // we can directly use ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();
        // or new newWorkStealingPool
//        ExecutorService executorServiceByAutoAllocateProcessor = Executors.newWorkStealingPool();
//        ExecutorService executorServiceByDefinedProcessors = Executors.newWorkStealingPool(5);

        SumTask task = new SumTask(numbers, 0, numbers.length - 1);
        ForkJoinTask<Integer> joinTask = pool.submit(task);
        try {
            Integer sum = joinTask.get();
            System.out.println("Sum: " + sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        //int sum = pool.invoke(task);

    }
}
