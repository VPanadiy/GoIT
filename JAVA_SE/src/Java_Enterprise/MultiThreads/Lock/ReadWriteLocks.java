package Java_Enterprise.MultiThreads.Lock;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Splayd on 05.02.2017.
 */
public class ReadWriteLocks {

    public static final int ARRAY_LENGTH = 10;

    public static void main(String[] args) {
        ConCurrentArray<Integer> array = new ConCurrentArray<>(ARRAY_LENGTH);
        IntStream.range(0, 3).forEach(i -> new Thread(() -> {
            while (true) {
                System.out.println("Reading " + Arrays.toString(array.read()));
            }
        }).start());
        new Thread(() -> {
            Random random = new Random();
            while (true) {
                Integer[] ints = Stream
                        .generate(random::nextInt)
                        .limit(random.nextInt(ARRAY_LENGTH + 1))
                        .toArray(Integer[]::new);

                array.write(ints, ARRAY_LENGTH - ints.length);
            }
        }).start();
    }

    public static class ConCurrentArray<T> {

        private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        private Object[] items;
        private Random random = new Random();

        public ConCurrentArray(int capacity) {
            items = new Object[capacity];
        }

        public void write(T[] values, int index) {
            readWriteLock.writeLock().lock();
            try {
                if (items.length < values.length + index) {
                    throw new RuntimeException("Not enough space");
                }
                System.arraycopy(values, 0, items, index, values.length);
                Thread.sleep(random.nextInt(1000));
                System.out.println("Array updated: " + Arrays.toString(items));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                readWriteLock.writeLock().unlock();
            }
        }

        public T[] read() {
            readWriteLock.readLock().lock();
            try {
                Object[] result = Arrays.copyOf(items, items.length);
                Thread.sleep(random.nextInt(100));
                return (T[]) result;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                readWriteLock.readLock().unlock();
            }
        }
    }
}
