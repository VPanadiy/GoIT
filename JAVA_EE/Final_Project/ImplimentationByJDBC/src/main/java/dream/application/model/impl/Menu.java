package dream.application.model.impl;

/**
 * MENU TABLE
 * Created by Splayd on 09.05.2017.
 */
public class Menu {

    private int numMENU;
    private String menuName;

    public int getNumMENU() {
        return numMENU;
    }

    public void setNumMENU(int numMENU) {
        this.numMENU = numMENU;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "numMENU=" + numMENU +
                ", menuName='" + menuName + '\'' +
                '}';
    }
}
