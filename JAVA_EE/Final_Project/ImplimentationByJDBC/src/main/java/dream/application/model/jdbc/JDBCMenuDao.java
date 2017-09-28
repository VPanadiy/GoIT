package dream.application.model.jdbc;

import dream.application.model.impl.Menu;
import dream.application.model.interfaces.*;
import dream.application.model.mapper.MenuMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * JDBC Menu DAO
 * Created by Splayd on 09.05.2017.
 */
public class JDBCMenuDao implements GetByIdDao, GetAllQueryDao, RemoveByNameQueryDao, InsertQueryDao, GetByNameDao, GetTotalRowDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private Menu menu;

    public JDBCMenuDao(Menu menu) {
        this.menu = menu;
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(JDBCMenuDao.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<JDBCMenuDao> getById(int id) {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM MENU WHERE MENU.NUM_MENU = ?";

        List<JDBCMenuDao> menuList = jdbcTemplate.query(sql,
                (ResultSet rs, int arg1) -> {
                    return getJdbcMenuDao(rs);
                }, id);
        menuList.forEach(result -> {
            Menu menu = result.getMenu();
        });
        return menuList;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void getAll() {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM MENU";

        List<Menu> menuList =
                this.jdbcTemplate.query(sql,
                        new MenuMapper());

        for (Menu menu : menuList) {
            System.out.println(menu);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List getByName(String name) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        List<String> resultMenu = new ArrayList<String>();

        String sql = "SELECT * FROM MENU WHERE MENU.MENU_NAME = ?";

        List<JDBCMenuDao> menuList = jdbcTemplate.query(sql,
                (ResultSet rs, int arg1) -> {
                    return getJdbcMenuDao(rs);
                }, name);
        menuList.forEach(result -> {
            Menu menu = result.getMenu();
            resultMenu.add("numMENU=" + menu.getNumMENU() + "," + " menuName=" + menu.getMenuName());
        });

        return resultMenu;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeByName(String name) {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "DELETE FROM MENU WHERE MENU.MENU_NAME = ?";

        jdbcTemplate.update(sql, name);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void insert() throws ParseException {
        int menuNum = getTotalRow() + 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter menu name: ");
        String menuName = scanner.nextLine();

        String sql = "INSERT INTO MENU VALUES (?,?)";

        jdbcTemplate.update(sql, menuNum, menuName);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Integer getTotalRow() {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT COUNT(*) FROM MENU";

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    private JDBCMenuDao getJdbcMenuDao(ResultSet rs) throws SQLException {
        menu.setNumMENU(rs.getInt("NUM_MENU"));
        menu.setMenuName(rs.getString("MENU_NAME"));
        return new JDBCMenuDao(menu);
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Menu getMenu() {
        return menu;
    }
}
