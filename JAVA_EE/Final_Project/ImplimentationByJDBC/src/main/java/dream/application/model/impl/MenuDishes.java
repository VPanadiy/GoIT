package dream.application.model.impl;

/**
 * MENU_DISHES TABLE
 * Created by Splayd on 09.05.2017.
 */
public class MenuDishes {

    private int menuId;
    private int dishId;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    @Override
    public String toString() {
        return "MenuDishes{" +
                "menuId=" + menuId +
                ", dishId=" + dishId +
                '}';
    }
}
