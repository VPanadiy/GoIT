package dream.application.model.jdbc;

import dream.application.model.impl.Ingredient;
import dream.application.model.interfaces.*;
import dream.application.model.mapper.IngredientMapper;
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
 * JDBC INGREDIENT DAO
 * Created by Splayd on 09.05.2017.
 */
public class JDBCIngredientDao implements GetAllQueryDao, GetByIdDao, GetTotalRowDao, InsertQueryDao, GetByNameDao, RemoveByNameQueryDao {

    private JDBCWarehouseDao jdbcWarehouseDao;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private final Ingredient ingredient;

    public JDBCIngredientDao(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(JDBCIngredientDao.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List getByName(String name) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        List<String> ingredientResultList = new ArrayList<>();

        String sql = "SELECT * FROM INGREDIENT WHERE INGREDIENT.INGREDIENT_NAME = ?";
        List<JDBCIngredientDao> ingredientList = jdbcTemplate.query(sql,
                (rs, arg1) -> {
                    return getJdbcIngredientDao(rs);
                }, name);
        ingredientList.forEach(result -> {
            Ingredient ingredient = result.getIngredient();
            ingredientResultList.add(ingredient.toString());
//            System.out.println(ingredient);
        });
        return ingredientResultList;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void insert() throws ParseException {
        jdbcTemplate = new JdbcTemplate(dataSource);

        Scanner scanner = new Scanner(System.in);
        int ingredientNum = getTotalRow() + 1;
        System.out.println("Enter ingredient name: ");
        String ingredientName = scanner.nextLine();

        String sql = "INSERT INTO INGREDIENT VALUES(?,?)";

        jdbcTemplate.update(sql, ingredientNum, ingredientName);

        jdbcWarehouseDao.insert();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void getAll() {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM INGREDIENT";

        List<Ingredient> ingredientList =
                this.jdbcTemplate.query(sql,
                        new IngredientMapper());

        for (Ingredient ingredient : ingredientList) {
            System.out.println(ingredient);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<JDBCIngredientDao> getById(int id) {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM INGREDIENT WHERE INGREDIENT.NUM_INGREDIENT = ?";

        List<JDBCIngredientDao> ingredientList = jdbcTemplate.query(sql,
                (ResultSet rs, int arg1) -> {
                    return getJdbcIngredientDao(rs);
                }, id);
        ingredientList.forEach(result -> {
            Ingredient ingredient = result.getIngredient();
        });
        return ingredientList;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Integer getTotalRow() {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT COUNT(*) FROM INGREDIENT";

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeByName(String name) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        int ingredientNum;

        List<String> ingredientsList = new ArrayList<String>();
        ingredientsList.add(getByName(name).toString());

        if (!ingredientsList.get(0).equals("[]")) {
            String beginNumString = "numIngredient=";
            String endNumString = ",";
            int beginNumParse = ingredientsList.get(0).lastIndexOf(beginNumString) + beginNumString.length();
            int endNumParse = ingredientsList.get(0).indexOf(endNumString);

            ingredientNum = Integer.parseInt(ingredientsList.get(0).substring(beginNumParse, endNumParse));
            jdbcWarehouseDao.removeById(ingredientNum);
        }

        String sql = "DELETE FROM INGREDIENT WHERE INGREDIENT.INGREDIENT_NAME = ?";

        jdbcTemplate.update(sql, name);
    }

    private JDBCIngredientDao getJdbcIngredientDao(ResultSet rs) throws SQLException {
        ingredient.setNumIngredient(rs.getInt("NUM_INGREDIENT"));
        ingredient.setIngredientName(rs.getString("INGREDIENT_NAME"));
        return new JDBCIngredientDao(ingredient);
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setJdbcWarehouseDao(JDBCWarehouseDao jdbcWarehouseDao) {
        this.jdbcWarehouseDao = jdbcWarehouseDao;
    }
}
