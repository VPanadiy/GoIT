package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by Splayd on 18.02.2017.
 */
@Configuration
public class AppConfig {

    @Bean
    public BootStrap bootStrap(ExecutorFactory executorFactory, TaskProvider<Integer> integerTaskProvider){
        BootStrap bootStrap = new BootStrap();
        bootStrap.setExecutorFactory(executorFactory);
        bootStrap.setTaskProvider(integerTaskProvider);
        return bootStrap;
    }

    @Bean
    public TaskProvider<Integer> integerTaskProvider(){
        IntegerTaskProvider integerTaskProvider = new IntegerTaskProvider();
        integerTaskProvider.init();
        return integerTaskProvider;
    }

    @Bean
    @Scope("prototype")
    public SerialExecutor<Integer> serialExecutor(){
        return new SerialExecutor<>();
    }

    @Bean
    public ExecutorFactory executorFactory(){
        return new ExecutorFactory() {
            @Override
            public Executor<Integer> getIntegerExecutor() {
                return serialExecutor();
            }
        };
    }
}
