package dream.application.model.impl;

/**
 * DISH_CREATED TABLE
 * Created by Splayd on 16.05.2017.
 */
public class DishCreated {

    private int id;
    private int dishNumber;
    private int employeeId;
    private int orderId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDishNumber() {
        return dishNumber;
    }

    public void setDishNumber(int dishNumber) {
        this.dishNumber = dishNumber;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "DishCreated{" +
                "id=" + id +
                ", dishNumber=" + dishNumber +
                ", employeeId=" + employeeId +
                ", orderId=" + orderId +
                '}';
    }
}
