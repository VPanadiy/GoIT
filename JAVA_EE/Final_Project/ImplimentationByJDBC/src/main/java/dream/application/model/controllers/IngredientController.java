package dream.application.model.controllers;

import dream.application.model.interfaces.*;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

/**
 * Ingredient Transaction Controller
 * Created by Splayd on 21.05.2017.
 */
public class IngredientController {

    private GetAllQueryDao getAllQueryDao;
    private GetByIdDao getByIdDao;
    private GetTotalRowDao getTotalRowDao;
    private InsertQueryDao insertQueryDao;
    private GetByNameDao getByNameDao;
    private RemoveByNameQueryDao removeByNameQueryDao;

    @Transactional
    public void chooseAction() throws ParseException {
        System.out.println("Choose Action (get, getAll, insert, remove): ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "getAll": {
                getAllFromIngredient();
                break;
            }
            case "get": {
                System.out.println("Please, enter the name of looking ingredient: ");
                getIngredientByName(scanner.nextLine());
                break;
            }
            case "remove": {
                System.out.println("Please, enter the name of looking ingredient for removing: ");
                removeIngredientByName(scanner.nextLine());
                break;
            }
            case "insert": {
                insertIngredient();
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
    public void getAllFromIngredient() {
        getAllQueryDao.getAll();
    }

    @Transactional
    public List getIngredientByID(int id) {
        return getByIdDao.getById(id);
    }

    @Transactional
    public Integer getIngredientTotalRow() {
        return getTotalRowDao.getTotalRow();
    }

    @Transactional
    public void insertIngredient() throws ParseException {
        insertQueryDao.insert();
    }

    @Transactional
    public List getIngredientByName(String name) {
        return getByNameDao.getByName(name);
    }

    @Transactional
    public void removeIngredientByName(String name) {
        removeByNameQueryDao.removeByName(name);
    }

    public void setGetByNameDao(GetByNameDao getByNameDao) {
        this.getByNameDao = getByNameDao;
    }

    public void setGetAllQueryDao(GetAllQueryDao getAllQueryDao) {
        this.getAllQueryDao = getAllQueryDao;
    }

    public void setGetByIdDao(GetByIdDao getByIdDao) {
        this.getByIdDao = getByIdDao;
    }

    public void setGetTotalRowDao(GetTotalRowDao getTotalRowDao) {
        this.getTotalRowDao = getTotalRowDao;
    }

    public void setInsertQueryDao(InsertQueryDao insertQueryDao) {
        this.insertQueryDao = insertQueryDao;
    }

    public void setRemoveByNameQueryDao(RemoveByNameQueryDao removeByNameQueryDao) {
        this.removeByNameQueryDao = removeByNameQueryDao;
    }
}
