package Java_Enterprise.Maven.AntExample.Executor.src;

/**
 * Created by Splayd on 11.02.2017.
 */
public interface Task<T> {

    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    Object getResult();
}
