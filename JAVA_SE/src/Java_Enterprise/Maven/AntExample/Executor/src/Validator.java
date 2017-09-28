package Java_Enterprise.Maven.AntExample.Executor.src;

/**
 * Created by Splayd on 11.02.2017.
 */
public interface Validator<T> {

    // Валидирует переданое значение
    boolean isValid(int result);
}
