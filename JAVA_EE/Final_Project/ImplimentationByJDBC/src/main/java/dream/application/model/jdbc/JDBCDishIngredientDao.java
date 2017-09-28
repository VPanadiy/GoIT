package dream.application.model.jdbc;

import dream.application.model.controllers.DishController;
import dream.application.model.impl.DishIngredient;
import dream.application.model.impl.Ingredient;
import dream.application.model.interfaces.*;
import dream.application.model.mapper.DishIngredientMapper;
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

/**
 * JDBC DISH_INGREDIENT DAO
 * Created by Splayd on 09.05.2017.
 */
public class JDBCDishIngredientDao implements GetTotalRowDao, GetByIdDao, InsertQueryDao, RemoveByIdQueryDao, GetAllQueryDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private DishIngredient dishIngredient;
    private Ingredient ingredient;

    private JDBCIngredientDao jdbcIngredientDao;
    private JDBCDishDao jdbcDishDao;
    private DishController dishController;

    public JDBCDishIngredientDao(DishIngredient dishIngredient) {
        this.dishIngredient = dishIngredient;
    }

    public JDBCDishIngredientDao(DishIngredient dishIngredient, Ingredient ingredient) {
        this.dishIngredient = dishIngredient;
        this.ingredient = ingredient;
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(JDBCDishIngredientDao.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeById(int id) {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "DELETE FROM DISH_INGREDIENT WHERE DISH_INGREDIENT.DISH_ID = ?";

        jdbcTemplate.update(sql, id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void insert() throws ParseException {
        jdbcTemplate = new JdbcTemplate(dataSource);
        int dishNum = jdbcDishDao.getTotalRow();
        int ingredientNum = 0;
        String dishName = "";
        List<String> dishes = new ArrayList<String>();
        dishes.add(jdbcIngredientDao.getByName(dishController.getIngredientName()).toString());
        String beginString = "ingredientName='";
        String endString = "'}]";
        int beginParse = dishes.get(0).lastIndexOf(beginString) + beginString.length();
        int endParse = dishes.get(0).lastIndexOf(endString);

        for (Object dishesName : dishes) {
            dishName = dishesName.toString().substring(beginParse, endParse);
        }

        if (dishName.equals("")) {
            ingredientNum = jdbcIngredientDao.getTotalRow() + 1;
        } else {
            String beginNumString = "numIngredient=";
            String endNumString = ",";
            int beginNumParse = dishes.get(0).lastIndexOf(beginNumString) + beginNumString.length();
            int endNumParse = dishes.get(0).indexOf(endNumString);

            for (Object dishesName : dishes) {
                ingredientNum = Integer.parseInt(dishesName.toString().substring(beginNumParse, endNumParse));
            }
        }

        if (ingredientNum == 0) return;

        String sql = "INSERT INTO DISH_INGREDIENT VALUES(?,?)";

        jdbcTemplate.update(sql, dishNum, ingredientNum);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List getById(int id) {
        List<String> dishIngredientNameList = new ArrayList<String>();
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT DISH_INGREDIENT.DISH_ID, DISH_INGREDIENT.INGREDIENT_ID, INGREDIENT.INGREDIENT_NAME FROM DISH_INGREDIENT INNER JOIN INGREDIENT ON INGREDIENT.NUM_INGREDIENT = DISH_INGREDIENT.INGREDIENT_ID WHERE DISH_INGREDIENT.DISH_ID = ? GROUP BY DISH_INGREDIENT.DISH_ID, INGREDIENT.INGREDIENT_NAME, DISH_INGREDIENT.DISH_ID, DISH_INGREDIENT.INGREDIENT_ID";

        List<JDBCDishIngredientDao> dishIngredientList = jdbcTemplate.query(sql,
                (ResultSet rs, int arg1) -> {
                    dishIngredient.setDishId(rs.getInt("DISH_ID"));
                    dishIngredient.setIngredientId(rs.getInt("INGREDIENT_ID"));
                    Ingredient ingredient = new Ingredient();
                    ingredient.setIngredientName(rs.getString("INGREDIENT_NAME"));

                    return new JDBCDishIngredientDao(dishIngredient, ingredient);
                }, id);
        dishIngredientList.forEach(result -> {
            DishIngredient dishIngredient = result.getDishIngredient();
            Ingredient ingredient = result.getIngredient();
            dishIngredientNameList.add(ingredient.getIngredientName());
        });
        return dishIngredientNameList;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Integer getTotalRow() {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT COUNT(DISH_INGREDIENT.DISH_ID) FROM DISH_INGREDIENT GROUP BY DISH_INGREDIENT.DISH_ID";

        List<JDBCDishIngredientDao> dishIngredientList = jdbcTemplate.query(sql,
                (ResultSet rs, int arg1) -> new JDBCDishIngredientDao(dishIngredient));
        dishIngredientList.forEach(result -> {
            DishIngredient dishIngredient = result.getDishIngredient();
        });
        return dishIngredientList.size();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void getAll() {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM DISH_INGREDIENT";

        List<DishIngredient> dishIngredientList =
                this.jdbcTemplate.query(sql,
                        new DishIngredientMapper());

        for (DishIngredient dishIngredient: dishIngredientList) {
            System.out.println(dishIngredient);
        }
    }

    public DishIngredient getDishIngredient() {
        return dishIngredient;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public JDBCDishDao getJdbcDishDao() {
        return jdbcDishDao;
    }

    public void setJdbcIngredientDao(JDBCIngredientDao jdbcIngredientDao) {
        this.jdbcIngredientDao = jdbcIngredientDao;
    }

    public void setJdbcDishDao(JDBCDishDao jdbcDishDao) {
        this.jdbcDishDao = jdbcDishDao;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
