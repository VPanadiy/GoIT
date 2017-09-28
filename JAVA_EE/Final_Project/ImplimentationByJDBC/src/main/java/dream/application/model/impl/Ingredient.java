package dream.application.model.impl;

/**
 * INGREDIENT TABLE
 * Created by Splayd on 09.05.2017.
 */
public class Ingredient {

    private int numIngredient;
    private String ingredientName;

    public int getNumIngredient() {
        return numIngredient;
    }

    public void setNumIngredient(int numIngredient) {
        this.numIngredient = numIngredient;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "numIngredient=" + numIngredient +
                ", ingredientName='" + ingredientName + '\'' +
                '}';
    }
}
