package dream.application.model.controllers;

import dream.application.model.interfaces.GetAllQueryDao;
import dream.application.model.interfaces.GetTotalRowDao;
import dream.application.model.interfaces.InsertQueryDao;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Scanner;

/**
 * DishCreates Transaction Controller
 * Created by Splayd on 22.06.2017.
 */
public class DishCreatedController {

    private GetTotalRowDao getTotalRowDao;
    private InsertQueryDao insertQueryDao;
    private GetAllQueryDao getAllQueryDao;

    @Transactional
    public void chooseAction() throws ParseException {
        System.out.println("Choose Action (insert, getAll): ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "getAll": {
                getAllCreatedDishes();
                break;
            }
            case "insert": {
                insertCreatedDish();
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
    public void insertCreatedDish() throws ParseException {
        insertQueryDao.insert();
    }

    @Transactional
    public void getAllCreatedDishes() {
        getAllQueryDao.getAll();
    }

    @Transactional
    public Integer getCreatedDishesTotalRow() {
        return getTotalRowDao.getTotalRow();
    }

    public void setGetTotalRowDao(GetTotalRowDao getTotalRowDao) {
        this.getTotalRowDao = getTotalRowDao;
    }

    public void setInsertQueryDao(InsertQueryDao insertQueryDao) {
        this.insertQueryDao = insertQueryDao;
    }

    public void setGetAllQueryDao(GetAllQueryDao getAllQueryDao) {
        this.getAllQueryDao = getAllQueryDao;
    }
}
