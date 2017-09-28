package Java_Enterprise.MultiThreads.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * Created by Splayd on 05.02.2017.
 */
public class Locks {

    private final Lock lock = new ReentrantLock(true); //order politic

    public static void main(String[] args) {
        final Locks locks = new Locks();
        IntStream.range(0,10).forEach(i -> new Thread(locks::testTryLock).start());
    }

    public void testLock() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " tries lock");
        try {
            lock.lock();
            System.out.println(threadName + " executing critical section");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(threadName + " realising lock");
            lock.unlock();
        }
    }

    public void testTryLock() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " tries lock");
        try {
            if (lock.tryLock(100, TimeUnit.NANOSECONDS)) {
                try {
                    System.out.println(threadName + " executing critical section");
                    Thread.sleep(10);
                } finally {
                    System.out.println(threadName + " realising lock");
                    lock.unlock();
                }
            } else {
                System.out.println(threadName + " unable acquire lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
