package dream.application.model.mapper;

import dream.application.model.impl.DishIngredient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DishIngredient RowMapper
 * Created by Splayd on 11.06.2017.
 */
public class DishIngredientMapper implements RowMapper<DishIngredient> {

    @Override
    public DishIngredient mapRow(ResultSet rs, int rowNum) throws SQLException {
        DishIngredient dishIngredient = new DishIngredient();
        dishIngredient.setDishId(rs.getInt("DISH_ID"));
        dishIngredient.setIngredientId(rs.getInt("INGREDIENT_ID"));
        return dishIngredient;
    }
}
