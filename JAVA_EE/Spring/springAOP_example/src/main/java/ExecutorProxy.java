import java.util.List;

/**
 * Created by Splayd on 30.04.2017.
 */
public class ExecutorProxy<T> implements Executor<T> {

    private Executor<T> executor;

    @Override
    public void addTask(Task<? extends T> task) {
        executor.addTask(task);
    }

    @Override
    public void addTask(Task<? extends T> task, Validator<? super T> validator) {
        executor.addTask(task, validator);
    }

    @Override
    public void execute() {
        System.out.println("ExecutorProxy before execute!");
        executor.execute();
        System.out.println("ExecutorProxy after execute!");
    }

    @Override
    public List<Object> getValidResults() {
        return executor.getValidResults();
    }

    @Override
    public List<Object> getInvalidResults() {
        return executor.getInvalidResults();
    }

    public void setExecutor(Executor<T> executor) {
        this.executor = executor;
    }
}
