package Java_Enterprise.Maven.MavenExample.src.main.java.maven;

/**
 * Created by Splayd on 11.02.2017.
 */
public interface Validator<T> {

    // Валидирует переданое значение
    boolean isValid(int result);
}
