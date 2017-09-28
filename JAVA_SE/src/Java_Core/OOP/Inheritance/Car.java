package Java_Core.OOP.Inheritance;

/**
 * Created by Splayd on 23.11.2016.
 */
public class Car {

    private Engine engine;

    private Weel[] weels;

    public Car(final Engine engine, final Weel[] weels) {
        this.weels = weels;
        if (weels.length != 4) {
            throw new IllegalArgumentException ("Car should have 4 weels");
        }
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public Weel[] getWeels() {
        return weels;
    }

    public boolean Start(){
        return this.engine.Start();
    }

}
