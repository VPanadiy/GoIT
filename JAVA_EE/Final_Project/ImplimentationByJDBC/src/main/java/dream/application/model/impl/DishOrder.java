package dream.application.model.impl;

/**
 * DISH_ORDER TABLE
 * Created by Splayd on 16.05.2017.
 */
public class DishOrder {

    private int orderId;
    private int dishId;
    private boolean isCreated;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public boolean isCreated() {
        return isCreated;
    }

    public void setCreated(boolean created) {
        isCreated = created;
    }

    @Override
    public String toString() {
        return "DishOrder{" +
                "orderId=" + orderId +
                ", dishId=" + dishId +
                ", isCreated=" + isCreated +
                '}';
    }
}
