package Java_Enterprise.MultiThreads.Lock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Created by Splayd on 05.02.2017.
 */
public class ExecutorsExample {

    public static void main(String[] args) throws Exception {
//        new ExecutorsExample().testExecute();
//        new ExecutorsExample().testSubmit();
//        new ExecutorsExample().testException();
//        new ExecutorsExample().testInvokeAny();
//        new ExecutorsExample().testInvokeAll();
//        new ExecutorsExample().Scheduled();
        new ExecutorsExample().testScheduledAtFixedRate();
    }

    public void testExecute() {
        Executor executor = Executors.newSingleThreadExecutor();
        System.out.println(Thread.currentThread().getName() + " submits task");
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": Async tasks started");
            }
        });
    }

    public void testSubmit() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> stringFuture = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "Task executed";
            }
        });
        System.out.println("Waiting for result");
        System.out.println("result: " + stringFuture.get());
        executorService.shutdown();
    }

    public void testException() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> stringFuture = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                throw new RuntimeException("Exception found");
            }
        });
        System.out.println("Waiting for result");
        Thread.sleep(1000);
        try {
            System.out.println("result: " + stringFuture.get());
        } catch (ExecutionException e) {
            System.out.println("Exception occurred");
        }
        executorService.shutdown();
    }

    public void testInvokeAny() throws ExecutionException, InterruptedException { // return First exceeded
        List<Callable<String>> callables = new ArrayList<>();
        Random random = new Random();
        IntStream.range(0, 3).forEach(i -> callables.add(() -> {
            Thread.sleep(random.nextInt(1000));
            return String.valueOf(i);
        }));
        ExecutorService executorService = Executors.newCachedThreadPool();
        String result = executorService.invokeAny(callables);
        System.out.println(result);
        executorService.shutdown();
    }

    public void testInvokeAll() throws ExecutionException, InterruptedException { // return All exceeded
        List<Callable<String>> callables = new ArrayList<>();
        Random random = new Random();
        IntStream.range(0, 3).forEach(i -> callables.add(() -> {
            Thread.sleep(random.nextInt(1000));
            return String.valueOf(i);
        }));
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> result = executorService.invokeAll(callables);
        for (Future f : result) {
            System.out.println(f.get());
        }
        executorService.shutdown();
    }

    public void Scheduled() {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        System.out.println("Task schedule " + new Date());
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("Task executed " + new Date());
            }
        }, 1, TimeUnit.SECONDS);
    }

    public void testScheduledAtFixedRate() throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        System.out.println("Task schedule " + new Date());
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Task executed " + new Date());
            }
        }, 1, 1, TimeUnit.SECONDS);

        Thread.sleep(10000);

        scheduledExecutorService.shutdown();
    }
}
