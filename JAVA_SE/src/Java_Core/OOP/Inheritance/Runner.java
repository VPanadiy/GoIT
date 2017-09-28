package Java_Core.OOP.Inheritance;

import java.util.ArrayList;

/**
 * Created by Splayd on 23.11.2016.
 */
public class Runner {
    public static void main(String[] args) {

        final ArrayList <Weel> weelList = new ArrayList<>();
        weelList.add(new Weel());
        weelList.add(new Weel());
        weelList.add(new Weel());
        weelList.add(new Weel());

        final Weel[] weels = new Weel[4];
        weels[0] = new Weel();
        weels[1] = new Weel();
        weels[2] = new WinterWeel();
        weels[3] = new WinterWeel();

        final Car car = new Car (new Engine(100), weels);

        System.out.println("New car has been started: " + car.Start());
    }
}
