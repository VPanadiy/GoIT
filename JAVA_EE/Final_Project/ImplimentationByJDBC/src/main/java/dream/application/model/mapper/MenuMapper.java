package dream.application.model.mapper;

import dream.application.model.impl.Menu;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Menu RowMapper
 * Created by Splayd on 10.06.2017.
 */
public class MenuMapper implements RowMapper<Menu> {
    @Override
    public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
        Menu menu = new Menu();
        menu.setNumMENU(rs.getInt("NUM_MENU"));
        menu.setMenuName(rs.getString("MENU_NAME"));
        return menu;
    }
}

