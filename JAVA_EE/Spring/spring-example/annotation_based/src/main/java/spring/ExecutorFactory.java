package spring;

import org.springframework.stereotype.Component;

/**
 * Created by Splayd on 18.02.2017.
 */
public abstract class ExecutorFactory {

    public abstract Executor<Integer> getIntegerExecutor();
}