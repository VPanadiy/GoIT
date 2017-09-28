package dream.application.model.jdbc;

import dream.application.model.impl.Menu;
import dream.application.model.impl.MenuDishes;
import dream.application.model.interfaces.*;
import dream.application.model.mapper.MenuDishesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * MENU_DISHES TABLE
 * Created by Splayd on 09.05.2017.
 */
public class JDBCMenuDishesDao implements GetTotalRowDao, UpdateQueryDao, GetByIdDao, InsertQueryDao, RemoveByIdQueryDao, RemoveByNameQueryDao, GetAllQueryDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private MenuDishes menuDishes;
    private Menu menu;

    private JDBCDishDao jdbcDishDao;
    private JDBCMenuDao jdbcMenuDao;

    public JDBCMenuDishesDao(MenuDishes menuDishes) {
        this.menuDishes = menuDishes;
    }

    public JDBCMenuDishesDao(MenuDishes menuDishes, Menu menu) {
        this.menuDishes = menuDishes;
        this.menu = menu;
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(JDBCMenuDishesDao.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void insert() throws ParseException {
        jdbcTemplate = new JdbcTemplate(dataSource);

        int menuNum = jdbcDishDao.getMenuId();
        int dishNum = jdbcDishDao.getTotalRow();

        String sql = "INSERT INTO MENU_DISHES VALUES (?,?)";

        jdbcTemplate.update(sql, menuNum, dishNum);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeByName(String name) {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "DELETE FROM MENU_DISHES WHERE MENU_DISHES.MENU_ID = ?";

        List<String> menuList = new ArrayList<String>();
        menuList.add(jdbcMenuDao.getByName(name).get(0).toString());
        if (!menuList.get(0).equals("")) {
            String beginNumString = "numMENU=";
            String endNumString = ",";
            int beginNumParse = menuList.get(0).lastIndexOf(beginNumString) + beginNumString.length();
            int endNumParse = menuList.get(0).indexOf(endNumString);

            for (String menus : menuList) {
                int menuNum = Integer.parseInt(menus.substring(beginNumParse, endNumParse));
                jdbcTemplate.update(sql, menuNum);
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeById(int id) {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "DELETE FROM MENU_DISHES WHERE MENU_DISHES.DISH_ID = ?";

        jdbcTemplate.update(sql, id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List getById(int id) {
        List<String> dishMenuNameList = new ArrayList<String>();
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT MENU_DISHES.MENU_ID, MENU_DISHES.DISH_ID, MENU.MENU_NAME FROM MENU_DISHES INNER JOIN MENU ON MENU.NUM_MENU = MENU_DISHES.MENU_ID WHERE MENU_DISHES.DISH_ID = ? GROUP BY MENU.MENU_NAME, MENU_DISHES.DISH_ID, MENU_DISHES.MENU_ID";

        List<JDBCMenuDishesDao> menuDishesList = jdbcTemplate.query(sql,
                (ResultSet rs, int arg1) -> {
                    menuDishes.setDishId(rs.getInt("DISH_ID"));
                    menuDishes.setMenuId(rs.getInt("MENU_ID"));
                    Menu menu = new Menu();
                    menu.setMenuName(rs.getString("MENU_NAME"));

                    return new JDBCMenuDishesDao(menuDishes, menu);
                }, id);
        menuDishesList.forEach(result -> {
            MenuDishes menuDishes = result.getMenuDishes();
            Menu menu = result.getMenu();
            dishMenuNameList.add(menu.getMenuName());
        });
        return dishMenuNameList;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Integer getTotalRow() {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT COUNT(MENU_DISHES.DISH_ID) FROM MENU_DISHES GROUP BY MENU_DISHES.DISH_ID";

        List<JDBCMenuDishesDao> menuDishesList = jdbcTemplate.query(sql,
                (ResultSet rs, int arg1) -> new JDBCMenuDishesDao(menuDishes));
        menuDishesList.forEach(result -> {
            MenuDishes menuDishes = result.getMenuDishes();
        });
        return menuDishesList.size();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void getAll() {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM MENU_DISHES";

        List<MenuDishes> menuDishesList =
                this.jdbcTemplate.query(sql,
                        new MenuDishesMapper());

        for (MenuDishes menuDishes : menuDishesList) {
            System.out.println(menuDishes);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want insert dish from menu or remove, type task (insert or remove): ");
        String task = scanner.nextLine();
        switch (task) {
            case "insert": {
                insertDishIntoMenu();
                break;
            }
            case "remove": {
                removeDishIntoMenu();
                break;
            }
            default: {
                System.out.println("Wrong value!");
                update();
            }
            case "exit":
                return;
        }
    }

    private void insertDishIntoMenu() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        Scanner scanner = new Scanner(System.in);

        String sql = "INSERT INTO MENU_DISHES VALUES (?,?)";
        System.out.println("Enter menu name where dish insert require: ");
        String menuName = scanner.nextLine();
        System.out.println("Enter dish name to insert into menu " + menuName + ": ");
        String dishName = scanner.nextLine();

        int menuNum = getMenuNum(menuName);
        int dishNum = getDishNum(dishName);

        executeUpdateQuery(sql, menuName, dishName, menuNum, dishNum);
    }

    private void removeDishIntoMenu() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        Scanner scanner = new Scanner(System.in);

        String sql = "DELETE FROM MENU_DISHES WHERE MENU_DISHES.MENU_ID = ? AND MENU_DISHES.DISH_ID = ?";
        System.out.println("Enter menu name where dish remove require: ");
        String menuName = scanner.nextLine();
        System.out.println("Enter dish name to remove from menu " + menuName + ": ");
        String dishName = scanner.nextLine();

        int menuNum = getMenuNum(menuName);
        int dishNum = getDishNum(dishName);

        executeUpdateQuery(sql, menuName, dishName, menuNum, dishNum);
    }

    private void executeUpdateQuery(String sql, String menuName, String dishName, int menuNum, int dishNum) {
        if (menuNum != 0 && dishNum != 0) {
            jdbcTemplate.update(sql, menuNum, dishNum);
        } else {
            if (menuNum == 0) {
                System.out.println("Menu with name " + menuName + " does not exist!");
            }

            if (dishNum == 0) {
                System.out.println("Dish with name " + dishName + " does not exist!");
            }
        }
    }

    private int getDishNum(String dishName) {
        int dishNum = 0;
        List<String> dishList = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        dishList.add(jdbcDishDao.getByName(dishName).get(0).toString());
        if (!dishList.get(0).equals("")) {
            for (int i = 0; i < dishList.get(0).length(); i++) {
                if (' ' == dishList.get(0).charAt(i)) break;
                builder.append(dishList.get(0).charAt(i));
            }
            dishNum = Integer.valueOf(builder.toString());
        }
        return dishNum;
    }

    private int getMenuNum(String menuName) {
        int menuNum = 0;
        List<String> menuList = new ArrayList<String>();
        menuList.add(jdbcMenuDao.getByName(menuName).get(0).toString());
        if (!menuList.get(0).equals("")) {
            String beginNumString = "numMENU=";
            String endNumString = ",";
            int beginNumParse = menuList.get(0).lastIndexOf(beginNumString) + beginNumString.length();
            int endNumParse = menuList.get(0).indexOf(endNumString);

            for (String menus : menuList) {
                menuNum = Integer.parseInt(menus.substring(beginNumParse, endNumParse));
            }
        }
        return menuNum;
    }

    public MenuDishes getMenuDishes() {
        return menuDishes;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setJdbcDishDao(JDBCDishDao jdbcDishDao) {
        this.jdbcDishDao = jdbcDishDao;
    }

    public void setJdbcMenuDao(JDBCMenuDao jdbcMenuDao) {
        this.jdbcMenuDao = jdbcMenuDao;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
