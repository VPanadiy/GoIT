package dream.application.model.impl;

import java.time.LocalDate;

/**
 * DISH_ORDER TABLE
 * Created by Splayd on 16.05.2017.
 */
public class GuestOrder {

    private int id;
    private int tableNumber;
    private LocalDate dateOrder;
    private int employeeId;
    private boolean isClosed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    @Override
    public String toString() {
        return "GuestOrder{" +
                "id=" + id +
                ", tableNumber=" + tableNumber +
                ", dateOrder=" + dateOrder +
                ", employeeId=" + employeeId +
                ", isClosed=" + isClosed +
                '}';
    }
}
