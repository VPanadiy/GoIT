package Java_Enterprise.Generics.Executor.src;

import java.util.*;

/**
 * Created by Splayd on 11.02.2017.
 */
public class SerialExecutor<T> implements Executor<T> {

    private static final Validator<Object> DEFAULT_VALIDATOR = value -> true;

    private List<TaskAndValidator<T>> tasks = new ArrayList<>();
    private List<T> validResult = new ArrayList<>();
    private List<T> invalidResult = new ArrayList<T>();

    private boolean executed = false;

    private Map<Task<? extends T>, Validator<? super T>> map = new HashMap<>();

    @Override
    public void addTask(Task<? extends T> task) {
        checkNotExecuted();
        tasks.add(new TaskAndValidator<T>(task, DEFAULT_VALIDATOR));
    }

    @Override
    public void addTask(Task<? extends T> task, Validator<? super T> validator) {
        tasks.add(new TaskAndValidator<T>(task, validator));
    }

    @Override
    public void execute() {
        checkNotExecuted();
        for (TaskAndValidator<T> taskAndValidator : tasks) {
            Task<? extends T> task = taskAndValidator.task;
            task.execute();
            if (taskAndValidator.validator.isValid((Integer) task.getResult())) {
                validResult.add((T) task.getResult());
            } else {
                invalidResult.add((T) task.getResult());
            }
        }
        executed = true;
    }

    @Override
    public List<T> getValidResults() {
        checkExecuted();
        return validResult;
    }

    @Override
    public List<T> getInvalidResults() {
        checkExecuted();
        return invalidResult;
    }

    public void checkNotExecuted() {
        if (executed){
            throw new IllegalStateException("Executor already executed");
        }
    }

    public void checkExecuted() {
        if (!executed){
            throw new IllegalStateException("Executor already executed");
        }
    }

    private static class TaskAndValidator<T> {

        private Task<? extends T> task;
        private Validator<? super T> validator;

        public TaskAndValidator(Task<? extends T> task, Validator<? super T> validator) {
            this.task = task;
            this.validator = validator;
        }
    }
}
