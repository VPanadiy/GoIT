package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Splayd on 11.02.2017.
 */
public class BootStrap{

    private TaskProvider<Integer> taskProvider;
    private ExecutorFactory executorFactory;


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        BootStrap bootstrap = applicationContext.getBean("bootstrap",BootStrap.class);
        bootstrap.execute();
        bootstrap.execute();
    }

    public void execute(){
        Executor<Integer> executor = executorFactory.getIntegerExecutor();
        taskProvider.getAllTasks().forEach(executor::addTask);
        executor.execute();
        System.out.println("Valid results:");
        executor.getValidResults().forEach(System.out::println);
        System.out.println("Invalid results");
        executor.getInvalidResults().forEach(System.out::println);
    }

    public void setTaskProvider(TaskProvider<Integer> taskProvider) {
        this.taskProvider = taskProvider;
    }

    public void setExecutorFactory(ExecutorFactory executorFactory) {
        this.executorFactory = executorFactory;
    }
}
