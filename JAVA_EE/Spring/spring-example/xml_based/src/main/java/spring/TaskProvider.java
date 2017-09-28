package spring;

import java.util.List;

/**
 * Created by Splayd on 18.02.2017.
 */
public interface TaskProvider<T> {

    List<Task<T>> getAllTasks();
}
