package dream.application.model.controllers;

import dream.application.model.interfaces.GetAllQueryDao;
import dream.application.model.interfaces.GetByNameDao;
import dream.application.model.interfaces.InsertQueryDao;
import dream.application.model.interfaces.RemoveByNameQueryDao;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Scanner;

/**
 * EMPLOYEE Transaction controller
 * Created by Splayd on 09.05.2017.
 */
public class EmployeeController {

    private GetAllQueryDao getAllQueryDao;
    private GetByNameDao getByNameDao;
    private RemoveByNameQueryDao removeByNameQueryDao;
    private InsertQueryDao insertQueryDao;

    @Transactional
    public void chooseAction() throws ParseException {
        System.out.println("Choose Action (get, getAll, insert, remove): ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "getAll": {
                getAllFromEmployee();
                break;
            }
            case "get": {
                System.out.println("Please, enter the name of looking employee: ");
                getEmployeeByName(scanner.nextLine());
                break;
            }
            case "remove": {
                System.out.println("Please, enter the name of looking employee for removing: ");
                removeEmployeeByName(scanner.nextLine());
                break;
            }
            case "insert": {
                insertEmployee();
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
    public void insertEmployee() throws ParseException {
        insertQueryDao.insert();
    }

    @Transactional
    public void removeEmployeeByName(String name) {
        removeByNameQueryDao.removeByName(name);
    }

    @Transactional
    public void getEmployeeByName(String name) {
        System.out.println(getByNameDao.getByName(name));
    }

    @Transactional
    public void getAllFromEmployee() {
        getAllQueryDao.getAll();
    }

    public void setGetAllQueryDao(GetAllQueryDao getAllQueryDao) {
        this.getAllQueryDao = getAllQueryDao;
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
}
