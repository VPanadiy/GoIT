package Java_Core.ExceptionExample;

/**
 * Created by Vitaliy on 29.11.2016.
 */
public class NegativeAgeException extends Exception {
    private int ageValue;

    public NegativeAgeException(int ageValue) {
        this.ageValue = ageValue;
    }

    public int getAgeValue() {
        return ageValue;
    }
}
