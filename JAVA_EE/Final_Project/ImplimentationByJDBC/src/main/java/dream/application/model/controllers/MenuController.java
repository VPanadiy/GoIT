package dream.application.model.controllers;

import dream.application.model.interfaces.*;
import dream.application.model.jdbc.JDBCMenuDishesDao;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Scanner;

/**
 * Menu Transaction Controller
 * Created by Splayd on 10.06.2017.
 */
public class MenuController {

    private JDBCMenuDishesDao jdbcMenuDishesDao;
    private GetAllQueryDao getAllQueryDao;
    private GetByNameDao getByNameDao;
    private InsertQueryDao insertQueryDao;
    private RemoveByNameQueryDao removeByNameQueryDao;
    private GetByIdDao getByIdDao;

    @Transactional
    public void chooseAction() throws ParseException {
        System.out.println("Choose Action (get, getAll, insert, remove, update): ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "getAll": {
                getAllFromMenu();
                break;
            }
            case "get": {
                System.out.println("Please, enter the name of looking menu: ");
                getMenuByName(scanner.nextLine());
                break;
            }
            case "remove": {
                System.out.println("Please, enter the name of looking menu for removing: ");
                removeMenuByName(scanner.nextLine());
                break;
            }
            case "insert": {
                insertMenu();
                break;
            }
            case "update": {
                jdbcMenuDishesDao.update();
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
    public void getAllFromMenu() {
        getAllQueryDao.getAll();
    }

    @Transactional
    public void insertMenu() throws ParseException {
        insertQueryDao.insert();
    }

    @Transactional
    public void getMenuByName(String name) {
        getByNameDao.getByName(name);
    }

    @Transactional
    public void removeMenuByName(String name) {
        jdbcMenuDishesDao.removeByName(name);
        removeByNameQueryDao.removeByName(name);
    }

    public void setGetAllQueryDao(GetAllQueryDao getAllQueryDao) {
        this.getAllQueryDao = getAllQueryDao;
    }

    public void setGetByIdDao(GetByIdDao getByIdDao) {
        this.getByIdDao = getByIdDao;
    }

    public void setGetByNameDao(GetByNameDao getByNameDao) {
        this.getByNameDao = getByNameDao;
    }

    public void setInsertQueryDao(InsertQueryDao insertQueryDao) {
        this.insertQueryDao = insertQueryDao;
    }

    public void setRemoveByNameQueryDao(RemoveByNameQueryDao removeByNameQueryDao) {
        this.removeByNameQueryDao = removeByNameQueryDao;
    }

    public void setJdbcMenuDishesDao(JDBCMenuDishesDao jdbcMenuDishesDao) {
        this.jdbcMenuDishesDao = jdbcMenuDishesDao;
    }
}
