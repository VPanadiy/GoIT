package dream.application.model.mapper;

import dream.application.model.impl.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Ingredient RowMapper
 * Created by Splayd on 21.05.2017.
 */
public class IngredientMapper implements org.springframework.jdbc.core.RowMapper<Ingredient> {

    public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ingredient ingredient = new Ingredient();
        ingredient.setNumIngredient(rs.getInt("NUM_INGREDIENT"));
        ingredient.setIngredientName(rs.getString("INGREDIENT_NAME"));
        return ingredient;
    }
}
