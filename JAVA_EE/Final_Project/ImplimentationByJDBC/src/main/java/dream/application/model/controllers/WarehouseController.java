package dream.application.model.controllers;

import dream.application.model.interfaces.*;
import dream.application.model.jdbc.JDBCIngredientDao;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Scanner;

/**
 * Warehouse Transaction Controller
 * Created by Splayd on 16.05.2017.
 */
public class WarehouseController {

    private GetAllQueryDao getAllQueryDao;
    private GetByNameDao getByNameDao;
    private InsertQueryDao insertQueryDao;
    private UpdateQueryDao updateQueryDao;
    private GetAllWithConditionQueryDao getAllWithConditionQueryDao;
    private JDBCIngredientDao jdbcIngredientDao;

    @Transactional
    public void chooseAction() throws ParseException {
        System.out.println("Choose Action (get, getAll, insert, remove, update, getLow): ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "getAll": {
                getAllFromWarehouse();
                break;
            }
            case "get": {
                System.out.println("Please, enter the name of looking ingredient: ");
                getIngredientFromWarehouseByName(scanner.nextLine());
                break;
            }
            case "remove": {
                System.out.println("Please, enter the name of looking ingredient for removing: ");
                jdbcIngredientDao.removeByName(scanner.nextLine());
                break;
            }
            case "insert": {
                jdbcIngredientDao.insert();
                break;
            }
            case "update": {
                updateFromWarehouse();
                break;
            }
            case "getLow": {
                getAllFromWarehouseWithCondition();
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
    public void getAllFromWarehouse() {
        getAllQueryDao.getAll();
    }

    @Transactional
    public void getAllFromWarehouseWithCondition() {
        getAllWithConditionQueryDao.getAllWithCondition();
    }

    @Transactional
    public void updateFromWarehouse() {
        updateQueryDao.update();
    }

    @Transactional
    public void getIngredientFromWarehouseByName(String name) {
        getByNameDao.getByName(name);
    }

    @Transactional
    public void insertIngredientInWarehouse() throws ParseException {
        insertQueryDao.insert();
    }

    public void setGetAllQueryDao(GetAllQueryDao getAllQueryDao) {
        this.getAllQueryDao = getAllQueryDao;
    }

    public void setInsertQueryDao(InsertQueryDao insertQueryDao) {
        this.insertQueryDao = insertQueryDao;
    }

    public void setUpdateQueryDao(UpdateQueryDao updateQueryDao) {
        this.updateQueryDao = updateQueryDao;
    }

    public void setGetByNameDao(GetByNameDao getByNameDao) {
        this.getByNameDao = getByNameDao;
    }

    public void setGetAllWithConditionQueryDao(GetAllWithConditionQueryDao getAllWithConditionQueryDao) {
        this.getAllWithConditionQueryDao = getAllWithConditionQueryDao;
    }

    public void setJdbcIngredientDao(JDBCIngredientDao jdbcIngredientDao) {
        this.jdbcIngredientDao = jdbcIngredientDao;
    }
}
