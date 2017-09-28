package dream.application.model.jdbc;

import dream.application.model.impl.DishCreated;
import dream.application.model.interfaces.GetAllQueryDao;
import dream.application.model.interfaces.GetTotalRowDao;
import dream.application.model.interfaces.InsertQueryDao;
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
 * JDBC DISH CREATED DAO
 * Created by Splayd on 16.05.2017.
 */
public class JDBCDishCreatedDao implements InsertQueryDao, GetTotalRowDao, GetAllQueryDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    private DishCreated dishCreated;
    private JDBCDishDao jdbcDishDao;
    private JDBCDishOrderDao jdbcDishOrderDao;
    private JDBCEmployeeDao jdbcEmployeeDao;
    private JDBCGuestOrderDao jdbcGuestOrderDao;

    public JDBCDishCreatedDao(DishCreated dishCreated) {
        this.dishCreated = dishCreated;
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(JDBCDishCreatedDao.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void insert() throws ParseException {
        jdbcTemplate = new JdbcTemplate(dataSource);
        Scanner scanner = new Scanner(System.in);
        List notCreatedDish = jdbcDishOrderDao.getAllWithCondition();
        List<String> dishList = new ArrayList<>();
        List<String> dishNameList = new ArrayList<>();
        String sql = "INSERT INTO DISH_CREATED VALUES (?,?,?,?)";

        System.out.println("Enter dish name order: ");
        String dishName = scanner.nextLine();

        for (Object dishes : notCreatedDish) {
            String dish = String.valueOf(dishes);
            String beginNumString = "dishId=";
            String endNumString = ", isCreated";
            int beginNumParse = dish.lastIndexOf(beginNumString) + beginNumString.length();
            int endNumParse = dish.indexOf(endNumString);

            int dishNum = Integer.parseInt(dish.substring(beginNumParse, endNumParse));
            dishList.add(jdbcDishDao.getById(dishNum).toString());
        }

        for (String dishesList : dishList) {
            String beginNumString = "Dish: ";
            String endNumString = ", Cost:";
            int beginNumParse = dishesList.lastIndexOf(beginNumString) + beginNumString.length();
            int endNumParse = dishesList.indexOf(endNumString);
            dishNameList.add(dishesList.substring(beginNumParse, endNumParse));
        }

        if (dishNameList.contains(dishName)) {
            int dishCreatedId = getTotalRow() + 1;

            List<String> dishesList = new ArrayList<>();
            dishesList.add(jdbcDishDao.getByName(dishName).get(0).toString());
            for (Object dishesForParse : dishesList) {
                String dishForParse = String.valueOf(dishesForParse);
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < dishForParse.length(); i++) {
                    if (' ' == dishForParse.charAt(i)) break;
                    builder.append(dishForParse.charAt(i));
                }
                int dishNumFound = Integer.parseInt(builder.toString());

                for (Object createdDish : notCreatedDish) {
                    String dish = String.valueOf(createdDish);
                    String beginNumStringForCompare = "dishId=";
                    String endNumStringForCompare = ", isCreated";
                    int beginNumParseForCompare = dish.lastIndexOf(beginNumStringForCompare) + beginNumStringForCompare.length();
                    int endNumParseForCompare = dish.indexOf(endNumStringForCompare);
                    int dishNum = Integer.parseInt(dish.substring(beginNumParseForCompare, endNumParseForCompare));
                    if (dishNumFound == dishNum) {
                        String beginNumStringOrderID = "orderId=";
                        String endNumStringOrderID = ", dishId";
                        int beginNumParseOrderID = dish.lastIndexOf(beginNumStringOrderID) + beginNumStringOrderID.length();
                        int endNumParseOrderID = dish.indexOf(endNumStringOrderID);
                        int orderId = Integer.parseInt(dish.substring(beginNumParseOrderID, endNumParseOrderID));
                        List guestOrderDish = jdbcGuestOrderDao.getById(orderId);

                        for (Object guestOrder : guestOrderDish) {
                            String order = String.valueOf(guestOrder);
                            String beginNumStringOrder = "employeeId=";
                            String endNumStringOrder = ", isClosed";
                            int beginNumParseOrder = order.lastIndexOf(beginNumStringOrder) + beginNumStringOrder.length();
                            int endNumParseOrder = order.indexOf(endNumStringOrder);

                            int employeeNum = Integer.parseInt(order.substring(beginNumParseOrder, endNumParseOrder));
                            jdbcTemplate.update(sql, dishCreatedId, dishNum, employeeNum, orderId);
                            jdbcDishOrderDao.updateStatus(orderId, dishNum);
                        }
                    }
                }
            }

        } else {
            System.out.println("Can not find dish name " + dishName + "in guest orders!");
        }
        scanner.close();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void getAll() {
        List<String> resultDishCreatedList = new ArrayList<>();
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM DISH_CREATED ORDER BY DISH_CREATED.ORDER_ID";

        List<JDBCDishCreatedDao> dishCreatedList = jdbcTemplate.query(sql,
                (rs, arg1) -> {
                    return getDishCreatedDao(rs);
                });
        dishCreatedList.forEach(result -> {
            DishCreated dishCreated = result.getDishCreated();
            String employeeName = getEmployeeName(dishCreated);
            String dishName = getDishName(dishCreated);
            resultDishCreatedList.add("id=" + dishCreated.getId() + ", dishName='" + dishName + "', employeeName='" + employeeName + "', orderId=" + dishCreated.getOrderId());
        });

        for (String createdDishes : resultDishCreatedList) {
            System.out.println(createdDishes);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Integer getTotalRow() {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT COUNT(*) FROM DISH_CREATED";

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    private String getEmployeeName(DishCreated dishCreated) {
        String employeeName = jdbcEmployeeDao.getById(dishCreated.getEmployeeId()).get(0).toString();
        String beginNumString = "surname='";
        String endNumString = "', name=";
        int beginNumParse = employeeName.lastIndexOf(beginNumString) + beginNumString.length();
        int endNumParse = employeeName.indexOf(endNumString);
        return employeeName.substring(beginNumParse, endNumParse);
    }

    private String getDishName(DishCreated dishCreated) {
        String dishName = jdbcDishDao.getById(dishCreated.getDishNumber()).get(0).toString();
        String beginNumString = "Dish: ";
        String endNumString = ", Cost:";
        int beginNumParse = dishName.lastIndexOf(beginNumString) + beginNumString.length();
        int endNumParse = dishName.indexOf(endNumString);
        return dishName.substring(beginNumParse, endNumParse);
    }

    private JDBCDishCreatedDao getDishCreatedDao(ResultSet rs) throws SQLException {
        DishCreated dishCreated = new DishCreated();
        dishCreated.setId(rs.getInt("ID"));
        dishCreated.setDishNumber(rs.getInt("DISH_NUMBER"));
        dishCreated.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
        dishCreated.setOrderId(rs.getInt("ORDER_ID"));
        return new JDBCDishCreatedDao(dishCreated);
    }

    public DishCreated getDishCreated() {
        return dishCreated;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setJdbcDishDao(JDBCDishDao jdbcDishDao) {
        this.jdbcDishDao = jdbcDishDao;
    }

    public void setJdbcEmployeeDao(JDBCEmployeeDao jdbcEmployeeDao) {
        this.jdbcEmployeeDao = jdbcEmployeeDao;
    }

    public void setJdbcDishOrderDao(JDBCDishOrderDao jdbcDishOrderDao) {
        this.jdbcDishOrderDao = jdbcDishOrderDao;
    }

    public void setJdbcGuestOrderDao(JDBCGuestOrderDao jdbcGuestOrderDao) {
        this.jdbcGuestOrderDao = jdbcGuestOrderDao;
    }
}
