package Java_Core.Collection;

/**
 * Created by Splayd on 10.12.2016.
 */
public class Film {
    private String name;
    private int year;
    private float rate;

    public Film(String name, int year, float rate) {
        this.name = name;
        this.year = year;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public float getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", rate=" + rate +
                '}';
    }
}
