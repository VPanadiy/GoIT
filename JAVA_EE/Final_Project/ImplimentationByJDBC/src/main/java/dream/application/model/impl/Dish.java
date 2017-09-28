package dream.application.model.impl;

/**
 * DISH TABLE
 * Created by Splayd on 09.05.2017.
 */
public class Dish{

    private int numDish;
    private String dishName;
    private float cost;
    private float weight;
    private int categoryId;

    public int getNumDish() {
        return numDish;
    }

    public void setNumDish(int numDish) {
        this.numDish = numDish;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "numDish=" + numDish +
                ", dishName='" + dishName + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                ", categoryId=" + categoryId +
                '}';
    }
}
