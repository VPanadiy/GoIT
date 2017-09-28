package Java_Core.OOP.Inheritance;

/**
 * Created by Splayd on 23.11.2016.
 */
public class Engine {

    private int power;

    public Engine() {
        this.power = 50;
    }

    public Engine(final int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public boolean Start(){
        return true;
    }

    public boolean Stop(){
        return true;
    }
}
