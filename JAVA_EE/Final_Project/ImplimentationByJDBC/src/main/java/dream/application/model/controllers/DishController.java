package dream.application.model.controllers;

import dream.application.model.interfaces.*;
import dream.application.model.jdbc.JDBCDishIngredientDao;
import dream.application.model.jdbc.JDBCIngredientDao;
import dream.application.model.jdbc.JDBCMenuDishesDao;
import dream.application.model.jdbc.JDBCWarehouseDao;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Dish Transaction Controller
 * Created by Splayd on 21.05.2017.
 */
public class DishController {

    private GetByIdDao getByIdDao;
    private GetTotalRowDao getTotalRowDao;
    private GetByNameDao getByNameDao;
    private RemoveByNameQueryDao removeByNameQueryDao;
    private InsertQueryDao insertQueryDao;

    private JDBCMenuDishesDao jdbcMenuDishesDao;
    private JDBCDishIngredientDao jdbcDishIngredientDao;
    private JDBCIngredientDao jdbcIngredientDao;
    private JDBCWarehouseDao jdbcWarehouseDao;

    private String ingredientName;

    @Transactional
    public void chooseAction() throws ParseException {
        System.out.println("Choose Action (get, getAll, insert, remove): ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "getAll": {
                getAllFromDishes();
                break;
            }
            case "get": {
                System.out.println("Please, enter the name of looking dish: ");
                getDishByName(scanner.nextLine());
                break;
            }
            case "remove": {
                System.out.println("Please, enter the name of looking dish for removing: ");
                removeDishByName(scanner.nextLine());
                break;
            }
            case "insert": {
                insertDish();
                break;
            }
            default: {
                System.out.println("Wrong value!");
                chooseAction();
            }
            case "exit":
                return;
        }
        scanner.close();
    }

    @Transactional
    public void getAllFromDishes() {
        int dishCount = getIngredientTotalRow();
        for (int i = 1; i <= dishCount; i++) {
            System.out.println(getDishById(i).toString().replace("[", "").replace("]", "") + ", Category: " + jdbcMenuDishesDao.getById(i).toString().replace("[", "").replace("]", "") + ", Ingredients: " + jdbcDishIngredientDao.getById(i));
        }
    }

    @Transactional
    public void insertDish() throws ParseException {
        insertQueryDao.insert();
        jdbcMenuDishesDao.insert();
        insertIngredients();
    }

    private void insertIngredients() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ingredients (to exit type \"exit\"): ");
        ingredientName = scanner.nextLine();
        switch (ingredientName) {
            default: {
                List<String> dishes = new ArrayList<String>();
                dishes.add(jdbcIngredientDao.getByName(ingredientName).toString());

                if (dishes.get(0).equals("[]")) {
                    choose();
                } else {
                    jdbcDishIngredientDao.insert();
                }
                insertIngredients();
                break;
            }
            case "exit":
        }
        scanner.close();
    }

    private void choose() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to add new ingredient (y/n)");
        switch (scanner.nextLine()) {
            case "y": {
                jdbcIngredientDao.insert();
                jdbcDishIngredientDao.insert();
                break;
            }
            case "n": {
                insertIngredients();
                break;
            }
            default: {
                System.out.println("Wrong value!");
                choose();
            }
        }
    }

    @Transactional
    public void removeDishByName(String name) {
        StringBuilder builder = new StringBuilder();

        String dishName = getByNameDao.getByName(name).toString().replace("[", "").replace("]", "");

        if (dishName.equals("")) return;

        for (int i = 0; i < dishName.length(); i++) {
            if (' ' == dishName.charAt(i)) break;
            builder.append(dishName.charAt(i));
        }

        int dishId = Integer.parseInt(builder.toString());

        jdbcMenuDishesDao.removeById(dishId);
        jdbcDishIngredientDao.removeById(dishId);
        removeByNameQueryDao.removeByName(name);
    }

    @Transactional
    public void getDishByName(String name) {
        StringBuilder builder = new StringBuilder();

        String dishName = getByNameDao.getByName(name).toString().replace("[", "").replace("]", "");

        if (dishName.equals("")) return;

        for (int i = 0; i < dishName.length(); i++) {
            if (' ' == dishName.charAt(i)) break;
            builder.append(dishName.charAt(i));
        }

        int dishId = Integer.parseInt(builder.toString());

        System.out.println(getByNameDao.getByName(name).toString().replace("[", "").replace("]", "") + ", Category: " + jdbcMenuDishesDao.getById(dishId).toString().replace("[", "").replace("]", "") + ", Ingredients: " + jdbcDishIngredientDao.getById(dishId));
    }

    @Transactional
    public List getDishById(int id) {
        return getByIdDao.getById(id);
    }

    @Transactional
    public Integer getIngredientTotalRow() {
        return getTotalRowDao.getTotalRow();
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setGetByIdDao(GetByIdDao getByIdDao) {
        this.getByIdDao = getByIdDao;
    }

    public void setGetTotalRowDao(GetTotalRowDao getTotalRowDao) {
        this.getTotalRowDao = getTotalRowDao;
    }

    public void setJdbcMenuDishesDao(JDBCMenuDishesDao jdbcMenuDishesDao) {
        this.jdbcMenuDishesDao = jdbcMenuDishesDao;
    }

    public void setJdbcDishIngredientDao(JDBCDishIngredientDao jdbcDishIngredientDao) {
        this.jdbcDishIngredientDao = jdbcDishIngredientDao;
    }

    public void setJdbcIngredientDao(JDBCIngredientDao jdbcIngredientDao) {
        this.jdbcIngredientDao = jdbcIngredientDao;
    }

    public void setGetByNameDao(GetByNameDao getByNameDao) {
        this.getByNameDao = getByNameDao;
    }

    public void setRemoveByNameQueryDao(RemoveByNameQueryDao removeByNameQueryDao) {
        this.removeByNameQueryDao = removeByNameQueryDao;
    }

    public void setInsertQueryDao(InsertQueryDao insertQueryDao) {
        this.insertQueryDao = insertQueryDao;
    }

    public void setJdbcWarehouseDao(JDBCWarehouseDao jdbcWarehouseDao) {
        this.jdbcWarehouseDao = jdbcWarehouseDao;
    }
}
