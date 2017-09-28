package Java_Enterprise.Generics.Executor.Test;

import Java_Enterprise.Generics.Executor.src.SerialExecutor;
import Java_Enterprise.Generics.Executor.src.Task;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Splayd on 11.02.2017.
 */
public class SerialExecutorTest {
    @Test
    public void testExecuteWithoutValidator() throws Exception {
        SerialExecutor<Integer> executor = new SerialExecutor<>();
        executor.addTask(new AddTask(1, 2));
        executor.execute();
        assertEquals("Wrong execution result", executor.getValidResults().get(0), Integer.valueOf(3));
        assertEquals("Wrong invalid result size", executor.getInvalidResults().size(), 0);
        assertEquals("Wrong valid result size", executor.getValidResults().size(), 1);
    }

    @Test
    public void testExecuteWithValidator() throws Exception {
        SerialExecutor<Integer> executor = new SerialExecutor<>();
        executor.addTask(new AddTask(1, -2), result -> result >= 0);
        executor.execute();
        assertEquals("Wrong valid result size", executor.getValidResults().size(), 0);
        assertEquals("Wrong invalid result size", executor.getInvalidResults().size(), 1);
        assertEquals("Wrong execution result", executor.getInvalidResults().get(0), Integer.valueOf(-1));
    }

    @Test
    public void testExecutor() throws Exception {
        SerialExecutor<Integer> executor = new SerialExecutor<>();
        executor.addTask(new AddTask(1, -2));
        executor.addTask(new AddTask(1, 2), result -> result >= 0);
        executor.addTask(new AddTask(1, -2), result -> result >= 0);
        executor.addTask(new AddTask(Integer.MAX_VALUE, 1), result -> result >= 0);

        executor.execute();

        assertEquals("Wrong valid result size", executor.getValidResults().size(), 2);
        assertEquals("Wrong invalid result size", executor.getInvalidResults().size(), 2);

        assertEquals("Wrong execution result", executor.getValidResults().get(0), Integer.valueOf(-1));
        assertEquals("Wrong execution result", executor.getValidResults().get(1), Integer.valueOf(3));

        assertEquals("Wrong execution result", executor.getInvalidResults().get(0), Integer.valueOf(-1));
        assertEquals("Wrong execution result", executor.getInvalidResults().get(1), Integer.valueOf(Integer.MIN_VALUE));
    }

    private static class AddTask implements Task<Integer> {

        private int value1;
        private int value2;
        private int result;

        public AddTask(int value1, int value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        @Override
        public void execute() {
            result = value1 + value2;
        }

        @Override
        public Object getResult() {
            return result;
        }
    }
}