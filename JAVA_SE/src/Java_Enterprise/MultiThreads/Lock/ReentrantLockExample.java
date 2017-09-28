package Java_Enterprise.MultiThreads.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Splayd on 11.02.2017.
 */
public class ReentrantLockExample {

    private final ReentrantLock lock = new ReentrantLock();

    private int i1 = 0;
    private int i2 = 0;

    public int incrementAndGetI1() {
        lock.lock();
        {
            try {
                return ++i1;
            } finally {
                lock.unlock();
            }
        }
    }

    public int incrementAndGetI1andI2() {
        lock.lock();
        try {
            return incrementAndGetI1() + ++i2;
        } finally {
            lock.unlock();
            lock.getHoldCount();
        }
    }
}
