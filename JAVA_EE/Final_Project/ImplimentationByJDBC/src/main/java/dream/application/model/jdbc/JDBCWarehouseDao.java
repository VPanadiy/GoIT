package dream.application.model.jdbc;

import dream.application.model.impl.Ingredient;
import dream.application.model.impl.Warehouse;
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
 * JDBC Warehouse DAO
 * Created by Splayd on 16.05.2017.
 */
public class JDBCWarehouseDao implements GetAllQueryDao, GetAllWithConditionQueryDao, GetByNameDao, InsertQueryDao, UpdateQueryDao, RemoveByIdQueryDao {

    private JDBCIngredientDao jdbcIngredientDao;
    private final Warehouse warehouse;
    private final Ingredient ingredient;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public JDBCWarehouseDao(Ingredient ingredient, Warehouse warehouse) {
        this.ingredient = ingredient;
        this.warehouse = warehouse;
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(JDBCWarehouseDao.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void insert() throws ParseException {
        jdbcTemplate = new JdbcTemplate(dataSource);
        Scanner scanner = new Scanner(System.in);

        int ingredientNum = jdbcIngredientDao.getTotalRow();
        System.out.println("Enter amount of ingredient: ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter unit of ingredient: ");
        String unit = scanner.nextLine();

        String sql = "INSERT INTO WAREHOUSE VALUES(?,?,?)";

        jdbcTemplate.update(sql, ingredientNum, amount, unit);
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void getAll() {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT WAREHOUSE.INGREDIENT_ID, INGREDIENT.NUM_INGREDIENT, INGREDIENT.INGREDIENT_NAME, WAREHOUSE.AMOUNT, WAREHOUSE.UNIT FROM WAREHOUSE INNER JOIN INGREDIENT ON WAREHOUSE.INGREDIENT_ID = INGREDIENT.NUM_INGREDIENT";
        List<JDBCWarehouseDao> ingredientsInWarehouse = jdbcTemplate.query(sql,
                (rs, arg1) -> {
                    return getJdbcWarehouseDao(rs);
                });

        ingredientsInWarehouse.forEach(result -> {
            Ingredient ingredient = result.getIngredient();
            Warehouse warehouse = result.getWarehouse();
            System.out.println(ingredient.getIngredientName() + " " + warehouse.getAmount() + " " + warehouse.getUnit());
        });
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeById(int id) {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "DELETE FROM WAREHOUSE WHERE WAREHOUSE.INGREDIENT_ID = ?";

        jdbcTemplate.update(sql, id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void update() {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "UPDATE WAREHOUSE SET AMOUNT = ? WHERE WAREHOUSE.INGREDIENT_ID = ?";

        System.out.println("Enter ingredient in the warehouse to change it amount: ");
        Scanner scanner = new Scanner(System.in);
        String ingredientName = scanner.nextLine();
        System.out.println("Enter amount of the ingredient " + ingredientName + ": ");
        float amount = scanner.nextFloat();
        scanner.close();

        List<String> ingredientsList = new ArrayList<String>();
        ingredientsList.add(jdbcIngredientDao.getByName(ingredientName).toString());

        if (!ingredientsList.get(0).equals("[]")) {
            String beginNumString = "numIngredient=";
            String endNumString = ",";
            int beginNumParse = ingredientsList.get(0).lastIndexOf(beginNumString) + beginNumString.length();
            int endNumParse = ingredientsList.get(0).indexOf(endNumString);

            int ingredientNum = Integer.parseInt(ingredientsList.get(0).substring(beginNumParse, endNumParse));

            jdbcTemplate.update(sql, amount, ingredientNum);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List getByName(String name) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        List<String> resultList = new ArrayList<String>();

        String sql = "SELECT WAREHOUSE.INGREDIENT_ID, INGREDIENT.NUM_INGREDIENT, INGREDIENT.INGREDIENT_NAME, WAREHOUSE.AMOUNT, WAREHOUSE.UNIT FROM WAREHOUSE INNER JOIN INGREDIENT ON WAREHOUSE.INGREDIENT_ID = INGREDIENT.NUM_INGREDIENT WHERE INGREDIENT.INGREDIENT_NAME = ?";
        List<JDBCWarehouseDao> ingredientsInWarehouse = jdbcTemplate.query(sql,
                (rs, arg1) -> {
                    return getJdbcWarehouseDao(rs);
                }, name);

        ingredientsInWarehouse.forEach(result -> {
            Ingredient ingredient = result.getIngredient();
            Warehouse warehouse = result.getWarehouse();
            resultList.add(ingredient.getIngredientName() + " " + warehouse.getAmount() + " " + warehouse.getUnit());
            System.out.println(ingredient.getIngredientName() + " " + warehouse.getAmount() + " " + warehouse.getUnit());
        });
        return resultList;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List getAllWithCondition() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        List<String> resultWarehouseList = new ArrayList<String>();

        System.out.println("Enter condition of amount value: ");
        Scanner scanner = new Scanner(System.in);
        float amount = scanner.nextFloat();
        scanner.close();

        String sql = "SELECT WAREHOUSE.INGREDIENT_ID, INGREDIENT.NUM_INGREDIENT, INGREDIENT.INGREDIENT_NAME, WAREHOUSE.AMOUNT, WAREHOUSE.UNIT FROM WAREHOUSE INNER JOIN INGREDIENT ON WAREHOUSE.INGREDIENT_ID = INGREDIENT.NUM_INGREDIENT WHERE WAREHOUSE.AMOUNT < ?";
        List<JDBCWarehouseDao> ingredientsInWarehouse = jdbcTemplate.query(sql,
                (rs, arg1) -> {
                    return getJdbcWarehouseDao(rs);
                }, amount);

        ingredientsInWarehouse.forEach(result -> {
            Ingredient ingredient = result.getIngredient();
            Warehouse warehouse = result.getWarehouse();
            resultWarehouseList.add(ingredient.getIngredientName() + " " + warehouse.getAmount() + " " + warehouse.getUnit());
        });
        for (String warehouseIngredients : resultWarehouseList) {
            System.out.println(warehouseIngredients);
        }
        return resultWarehouseList;
    }

    private JDBCWarehouseDao getJdbcWarehouseDao(ResultSet rs) throws SQLException {
        Ingredient ingredient = new Ingredient();
        ingredient.setNumIngredient(rs.getInt("NUM_INGREDIENT"));
        ingredient.setIngredientName(rs.getString("INGREDIENT_NAME"));
        Warehouse warehouse = new Warehouse();
        warehouse.setIngredientId(rs.getInt("INGREDIENT_ID"));
        warehouse.setAmount(rs.getFloat("AMOUNT"));
        warehouse.setUnit(rs.getString("UNIT"));
        return new JDBCWarehouseDao(ingredient, warehouse);
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setJdbcIngredientDao(JDBCIngredientDao jdbcIngredientDao) {
        this.jdbcIngredientDao = jdbcIngredientDao;
    }
}
