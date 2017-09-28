package Java_Enterprise.Generics.Executor.src;

/**
 * Validator interface
 * Created by Splayd on 11.02.2017.
 */
public interface Validator<T> {

    // Валидирует переданое значение
    boolean isValid(int result);
}
