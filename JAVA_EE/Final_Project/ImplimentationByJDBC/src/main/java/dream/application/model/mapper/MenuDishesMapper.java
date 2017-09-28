package dream.application.model.mapper;

import dream.application.model.impl.MenuDishes;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * MenuDishes RowMapper
 * Created by Splayd on 11.06.2017.
 */
public class MenuDishesMapper implements RowMapper<MenuDishes> {

    @Override
    public MenuDishes mapRow(ResultSet rs, int rowNum) throws SQLException {
        MenuDishes menuDishes = new MenuDishes();
        menuDishes.setMenuId(rs.getInt("MENU_ID"));
        menuDishes.setDishId(rs.getInt("DISH_ID"));
        return menuDishes;
}
}
