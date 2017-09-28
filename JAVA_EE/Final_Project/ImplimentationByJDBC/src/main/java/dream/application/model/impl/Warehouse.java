package dream.application.model.impl;

/**
 * WAREHOUSE TABLE
 * Created by Splayd on 16.05.2017.
 */
public class Warehouse {

    private int ingredientId;
    private float amount;
    private String unit;

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "ingredientId=" + ingredientId +
                ", amount=" + amount +
                ", unit='" + unit + '\'' +
                '}';
    }
}
