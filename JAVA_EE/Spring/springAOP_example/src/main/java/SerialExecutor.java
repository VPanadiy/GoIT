import java.util.ArrayList;
import java.util.List;


/**
 * Created by Splayd on 11.02.2017.
 * Example project for Ant
 */
public class SerialExecutor<T> implements Executor<T> {

    private static final Validator<Object> DEFAULT_VALIDATOR = value -> true;

    private List<TaskAndValidator<T>> tasks = new ArrayList<>();
    private List<Object> validResult = new ArrayList<>();
    private List<Object> invalidResult = new ArrayList<>();

    private boolean executed = false;

    @Override
    public void addTask(Task<? extends T> task) {
        checkNotExecuted();
        tasks.add(new TaskAndValidator<>(task, DEFAULT_VALIDATOR));
    }

    @Override
    public void addTask(Task<? extends T> task, Validator<? super T> validator) {
        tasks.add(new TaskAndValidator<>(task, validator));
    }

    @Override
    public void execute() {
        checkNotExecuted();
        for (TaskAndValidator<T> taskAndValidator : tasks) {
            Task<? extends T> task = taskAndValidator.task;
            task.execute();
            if (taskAndValidator.validator.isValid((Integer) task.getResult())) {
                validResult.add(task.getResult());
            } else {
                invalidResult.add(task.getResult());
            }
        }
        executed = true;
    }

    @Override
    public List<Object> getValidResults() {
        checkExecuted();
        return validResult;
    }

    @Override
    public List<Object> getInvalidResults() {
        checkExecuted();
        return invalidResult;
    }

    private void checkNotExecuted() {
        if (executed){
            throw new IllegalStateException("Executor already executed");
        }
    }

    private void checkExecuted() {
        if (!executed){
            throw new IllegalStateException("Executor already executed");
        }
    }

    private static class TaskAndValidator<T> {

        private Task<? extends T> task;
        private Validator<? super T> validator;

        TaskAndValidator(Task<? extends T> task, Validator<? super T> validator) {
            this.task = task;
            this.validator = validator;
        }
    }
}
