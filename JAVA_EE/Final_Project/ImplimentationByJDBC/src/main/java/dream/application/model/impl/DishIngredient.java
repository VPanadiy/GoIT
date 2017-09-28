package dream.application.model.impl;

/**
 * DISH_INGREDIENT TABLE
 * Created by Splayd on 09.05.2017.
 */
public class DishIngredient {

    private int dishId;
    private int ingredientId;

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Override
    public String toString() {
        return "DishIngredient{" +
                "dishId=" + dishId +
                ", ingredientId=" + ingredientId +
                '}';
    }
}
