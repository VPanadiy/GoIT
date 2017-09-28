package dream.application.model.jdbc;

import dream.application.model.impl.DishOrder;
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
 * JDBC DISH ORDER DAO
 * Created by Splayd on 17.06.2017.
 */
public class JDBCDishOrderDao implements InsertQueryDao, UpdateQueryDao, RemoveByIdQueryDao, GetTotalRowDao, GetAllQueryDao, GetAllWithConditionQueryDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    private DishOrder dishOrder;

    private JDBCDishDao jdbcDishDao;
    private JDBCGuestOrderDao jdbcGuestOrderDao;

    public JDBCDishOrderDao(DishOrder dishOrder) {
        this.dishOrder = dishOrder;
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(JDBCDishOrderDao.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeById(int id) {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "DELETE FROM DISH_ORDER WHERE DISH_ORDER.ORDER_ID = ?";

        jdbcTemplate.update(sql, id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void insert() throws ParseException {
        jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO DISH_ORDER VALUES (?,?,false)";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter order id to insert dish: ");
        int orderNum = scanner.nextInt();
        updateDish(orderNum, sql);
        scanner.close();
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void update() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "DELETE FROM DISH_ORDER WHERE DISH_ORDER.ORDER_ID = ? AND DISH_ORDER.DISH_ID = ?";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter order id to remove dish: ");
        int orderNum = scanner.nextInt();
        scanner.nextLine();
        updateDish(orderNum, sql);
    }

    public void updateDish(int orderNum, String sql) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of the dish: ");
        String dishName = scanner.nextLine();

        switch (dishName) {
            case "exit":
                return;
            default: {
                List<String> dishes = new ArrayList<String>();
                dishes.add(jdbcDishDao.getByName(dishName).toString());
                if (dishes.get(0).equals("[]")) {
                    System.out.println("Dish with the name " + dishName + " does not exist!");
                    updateDish(orderNum, sql);
                } else {
                    StringBuilder builder = new StringBuilder();

                    String dish = jdbcDishDao.getByName(dishName).get(0).toString().replace("[", "").replace("]", "");

                    if (dish.equals("")) return;

                    for (int i = 0; i < dish.length(); i++) {
                        if (' ' == dish.charAt(i)) break;
                        builder.append(dish.charAt(i));
                    }

                    int dishId = Integer.parseInt(builder.toString());

                    List<String> orderList = new ArrayList<>();
                    orderList.add(jdbcGuestOrderDao.getById(orderNum).get(0).toString());
                    if (!orderList.get(0).equals("")) {
                        String beginNumString = "isClosed=";
                        String endNumString = "}]";
                        int beginNumParse = orderList.get(0).lastIndexOf(beginNumString) + beginNumString.length();
                        int endNumParse = orderList.get(0).indexOf(endNumString);

                        for (String employees : orderList) {
                            boolean orderStatus = Boolean.parseBoolean(employees.substring(beginNumParse, endNumParse));
                            if (!orderStatus) {
                                jdbcTemplate.update(sql, orderNum, dishId);
                                updateDish(orderNum, sql);
                            } else {
                                System.out.println("Order status is closed!");
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void getAll() {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM DISH_ORDER";
        List<JDBCDishOrderDao> dishOrderList = jdbcTemplate.query(sql,
                (rs, arg1) -> {
                    return getDishOrderDao(rs);
                });
        dishOrderList.forEach(result -> {
            DishOrder dishOrder = result.getDishOrder();
            System.out.println(dishOrder);
        });
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List getAllWithCondition() {
        List<String> resultDishOrderList = new ArrayList<>();
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM DISH_ORDER WHERE IS_CREATED = FALSE";

        List<JDBCDishOrderDao> dishOrderList = jdbcTemplate.query(sql,
                (rs, arg1) -> {
                    return getDishOrderDao(rs);
                });
        dishOrderList.forEach(result -> {
            DishOrder dishOrder = result.getDishOrder();
            resultDishOrderList.add(dishOrder.toString());
        });
        return resultDishOrderList;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void updateStatus(int orderNum, int dishId) {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "UPDATE DISH_ORDER SET IS_CREATED = TRUE WHERE ORDER_ID = ? AND DISH_ID = ?";

        jdbcTemplate.update(sql, orderNum, dishId);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Integer getTotalRow() {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT COUNT(*) FROM DISH_ORDER";

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    private JDBCDishOrderDao getDishOrderDao(ResultSet rs) throws SQLException {
        DishOrder dishOrder = new DishOrder();
        dishOrder.setOrderId(rs.getInt("ORDER_ID"));
        dishOrder.setDishId(rs.getInt("DISH_ID"));
        dishOrder.setCreated(rs.getBoolean("IS_CREATED"));
        return new JDBCDishOrderDao(dishOrder);
    }

    public DishOrder getDishOrder() {
        return dishOrder;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setJdbcDishDao(JDBCDishDao jdbcDishDao) {
        this.jdbcDishDao = jdbcDishDao;
    }

    public void setJdbcGuestOrderDao(JDBCGuestOrderDao jdbcGuestOrderDao) {
        this.jdbcGuestOrderDao = jdbcGuestOrderDao;
    }
}
