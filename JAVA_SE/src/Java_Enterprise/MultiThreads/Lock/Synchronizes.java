package Java_Enterprise.MultiThreads.Lock;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.stream.IntStream;

/**
 * Created by Splayd on 05.02.2017.
 */
public class Synchronizes {

    public static void main(String[] args) throws InterruptedException {
        Synchronizes synchronizes = new Synchronizes();
        //synchronizes.testCyclicBarrier();
        synchronizes.testExchanger();
    }

    public void testCyclicBarrier() throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(5, () -> System.out.println("Barrier exceeded"));
        while (true) {
            new Thread(() -> {
                try {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + " starts waiting on barrier");
                    barrier.await();
                    System.out.println(threadName + " finish waiting");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
            Thread.sleep(1000);
        }
    }

    public void testExchanger() {
        Exchanger<String> stringExchanger = new Exchanger<>();
        Random random = new Random();
        IntStream.range(0, 2).forEach((i) -> new Thread(() -> {
            try {
                Thread.sleep(random.nextInt(1000));
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " ready to exchange");
                System.out.println(threadName + " < - > " + stringExchanger.exchange(threadName));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start());
    }
}

