package dream.application.model.controllers;

import dream.application.model.interfaces.*;
import dream.application.model.jdbc.JDBCDishOrderDao;
import dream.application.model.jdbc.JDBCGuestOrderDao;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Scanner;

/**
 * GuestOrder Transaction Controller
 * Created by Splayd on 17.06.2017.
 */
public class GuestOrderController {

    private GetAllQueryDao getAllQueryDao;
    private InsertQueryDao insertQueryDao;
    private GetByNameDao getByNameDao;
    private RemoveByIdQueryDao removeByIdQueryDao;
    private GetByIdDao getByIdDao;
    private UpdateQueryDao updateQueryDao;
    private GetTotalRowDao getTotalRowDao;

    private JDBCDishOrderDao jdbcDishOrderDao;
    private JDBCGuestOrderDao jdbcGuestOrderDao;

    @Transactional
    public void chooseAction() throws ParseException {
        System.out.println("Choose Action (get (closed or open), getAll, insert, remove, update): ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "getAll": {
                getAllFromOrder();
                break;
            }
            case "get": {
                System.out.println("Please, enter order status (true/false): ");
                getOrderStatus(scanner.nextLine());
                break;
            }
            case "update": {
                updateOrder();
                break;
            }
            case "remove": {
                System.out.println("Please, enter id of the order for removing: ");
                removeOrder(scanner.nextInt());
                break;
            }
            case "insert": {
                insertOrder();
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
    public void getAllFromOrder() {
        getAllQueryDao.getAll();
    }

    @Transactional
    public void insertOrder() throws ParseException {
        insertQueryDao.insert();
        defineOrders();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    private void defineOrders() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Took order(yes/no): ");
        String defineOrder = scanner.nextLine();
        switch (defineOrder) {
            case "yes": {
                String sql = "INSERT INTO DISH_ORDER VALUES (?,?,false)";
                int orderNum = jdbcGuestOrderDao.getTotalRow();
                jdbcDishOrderDao.updateDish(orderNum, sql);
                break;
            }
            case "no":
                return;
            default: {
                System.out.println("Wrong value!");
                defineOrders();
            }
        }
        scanner.close();
    }

    public void updateOrder() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose action(insert,remove,close): ");
        String orderAction = scanner.nextLine();
        switch (orderAction) {
            case "insert": {
                insertDishInOrder();
                break;
            }
            case "remove": {
                removeDishInOrder();
                break;
            }
            case "close": {
                jdbcGuestOrderDao.update();
                break;
            }
            case "exit":
                return;
            default: {
                System.out.println("Wrong value!");
                updateOrder();
            }
        }
    }

    @Transactional
    private void insertDishInOrder() throws ParseException {
        jdbcDishOrderDao.insert();
    }

    @Transactional
    private void removeDishInOrder() throws ParseException {
        jdbcDishOrderDao.update();
    }

    @Transactional
    public void removeOrder(int id) {
        removeByIdQueryDao.removeById(id);
    }

    @Transactional
    public void getOrderStatus(String name) throws ParseException {
        if (name.equals("true") || name.equals("false")) {
            getByNameDao.getByName(name);
        } else {
            System.out.println("Wrong value!");
            chooseAction();
        }
    }

    @Transactional
    public void getById(int id) {
        getByIdDao.getById(id);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void getTotalRow() {
        System.out.println(getTotalRowDao.getTotalRow());
    }

    public void setGetAllQueryDao(GetAllQueryDao getAllQueryDao) {
        this.getAllQueryDao = getAllQueryDao;
    }

    public void setInsertQueryDao(InsertQueryDao insertQueryDao) {
        this.insertQueryDao = insertQueryDao;
    }

    public void setGetByNameDao(GetByNameDao getByNameDao) {
        this.getByNameDao = getByNameDao;
    }

    public void setRemoveByIdQueryDao(RemoveByIdQueryDao removeByIdQueryDao) {
        this.removeByIdQueryDao = removeByIdQueryDao;
    }

    public void setGetByIdDao(GetByIdDao getByIdDao) {
        this.getByIdDao = getByIdDao;
    }

    public void setJdbcDishOrderDao(JDBCDishOrderDao jdbcDishOrderDao) {
        this.jdbcDishOrderDao = jdbcDishOrderDao;
    }

    public void setUpdateQueryDao(UpdateQueryDao updateQueryDao) {
        this.updateQueryDao = updateQueryDao;
    }

    public void setGetTotalRowDao(GetTotalRowDao getTotalRowDao) {
        this.getTotalRowDao = getTotalRowDao;
    }

    public void setJdbcGuestOrderDao(JDBCGuestOrderDao jdbcGuestOrderDao) {
        this.jdbcGuestOrderDao = jdbcGuestOrderDao;
    }
}
