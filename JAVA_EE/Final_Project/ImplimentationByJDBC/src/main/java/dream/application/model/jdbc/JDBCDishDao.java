package dream.application.model.jdbc;

import dream.application.model.impl.Dish;
import dream.application.model.interfaces.*;
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
 * JDBC WAREHOUSE DAO
 * Created by Splayd on 09.05.2017.
 */
public class JDBCDishDao implements GetByIdDao, GetTotalRowDao, GetByNameDao, InsertQueryDao, RemoveByNameQueryDao {

    private final Dish dish;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    private int menuId;

    public static final Logger LOGGER = LoggerFactory.getLogger(JDBCDishDao.class);

    public JDBCDishDao(Dish dish) {
        this.dish = dish;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List getById(int id) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        List<String> dishResultList = new ArrayList<>();

        String sql = "SELECT DISH.NUM_DISH, DISH.DISH_NAME, DISH.COST, DISH.WEIGHT FROM DISH \n" +
                "\tWHERE DISH.NUM_DISH = ? \n" +
                "\tGROUP BY DISH.NUM_DISH, DISH.DISH_NAME, DISH.COST, DISH.WEIGHT ORDER BY DISH.NUM_DISH;";

        List<JDBCDishDao> dishList = jdbcTemplate.query(sql,
                (ResultSet rs, int arg1) -> {
                    return getJdbcDishDao(rs);
                }, id);
        dishList.forEach(result -> {
            Dish dish = result.getDish();
//            System.out.println(dish.getNumDish() + " " + dish.getDishName() + " " + dish.getCost() + " " + dish.getWeight());
            dishResultList.add(String.valueOf(dish.getNumDish()) + " Dish: " + dish.getDishName() + ", Cost: " + dish.getCost() + " $, Weight: " + dish.getWeight() + " grams");
        });
        return dishResultList;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Integer getTotalRow() {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT COUNT(*) FROM DISH";

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List getByName(String name) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        List<String> dishResultList = new ArrayList<>();

        String sql = "SELECT DISH.NUM_DISH, DISH.DISH_NAME, DISH.COST, DISH.WEIGHT FROM DISH \n" +
                "\tWHERE DISH.DISH_NAME = ? \n" +
                "\tGROUP BY DISH.NUM_DISH, DISH.DISH_NAME, DISH.COST, DISH.WEIGHT ORDER BY DISH.NUM_DISH;";

        List<JDBCDishDao> dishList = jdbcTemplate.query(sql,
                (ResultSet rs, int arg1) -> {
                    return getJdbcDishDao(rs);
                }, name);
        dishList.forEach(result -> {
            Dish dish = result.getDish();
//            System.out.println(dish.getNumDish() + " " + dish.getDishName() + " " + dish.getCost() + " " + dish.getWeight());
            dishResultList.add(String.valueOf(dish.getNumDish()) + " Dish: " + dish.getDishName() + ", Cost: " + dish.getCost() + " $, Weight: " + dish.getWeight() + " grams");
        });

        return dishResultList;
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeByName(String name) {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "DELETE FROM DISH WHERE DISH.DISH_NAME = ?";

        jdbcTemplate.update(sql, name);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void insert() throws ParseException {
        jdbcTemplate = new JdbcTemplate(dataSource);

        Scanner scanner = new Scanner(System.in);
        int num = getTotalRow() + 1;
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter cost: ");
        float cost = scanner.nextFloat();
        System.out.println("Enter weight: ");
        float weight = scanner.nextFloat();
        System.out.println("Enter category id: ");
        int categoryId = scanner.nextInt();
        menuId = categoryId;

        String sql = "INSERT INTO DISH VALUES (?,?,?,?,?)";

        jdbcTemplate.update(sql, num, name, cost, weight, categoryId);
    }

    private JDBCDishDao getJdbcDishDao(ResultSet rs) throws SQLException {
        dish.setNumDish(rs.getInt("NUM_DISH"));
        dish.setDishName(rs.getString("DISH_NAME"));
        dish.setCost(rs.getFloat("COST"));
        dish.setWeight(rs.getFloat("WEIGHT"));

        return new JDBCDishDao(dish);
    }

    public Dish getDish() {
        return dish;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
