package dream.application;

import dream.application.model.controllers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.util.Scanner;

/**
 * Boot Class
 * Created by Splayd on 09.05.2017.
 */
public class Boot_API_Controller {

    public static final Logger LOGGER = LoggerFactory.getLogger(Boot_API_Controller.class);

    private EmployeeController employeeController;
    private WarehouseController warehouseController;
    private DishController dishController;
    private IngredientController ingredientController;
    private DishIngredientController dishIngredientController;
    private MenuController menuController;
    private MenuDishesController menuDishesController;
    private GuestOrderController guestOrderController;
    private DishCreatedController dishCreatedController;
    private DishOrderController dishOrderController;

    public static void main(String[] args) throws ParseException {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Boot_API_Controller bootApiController = context.getBean(Boot_API_Controller.class);
        bootApiController.choseTableForAction();
    }

    private void choseTableForAction() throws ParseException {
        System.out.println("Choose Table (employee, dish, warehouse, menu, order, kitchen): ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "employee": {
                employeeController.chooseAction();
                break;
            }
            case "dish": {
                dishController.chooseAction();
                break;
            }
            case "warehouse": {
                warehouseController.chooseAction();
                break;
            }
            case "menu": {
                menuController.chooseAction();
                break;
            }
            case "order": {
                guestOrderController.chooseAction();
                break;
            }
            case "kitchen": {
                dishCreatedController.chooseAction();
                break;
            }
            default: {
                System.out.println("Wrong value!");
                choseTableForAction();
            }
            case "exit":
                return;
        }
        scanner.close();
    }


    private void getAllDishes() {
        dishController.getAllFromDishes();
    }

    private void startDish() {
        dishController.getAllFromDishes();
    }

    private void startWarehouse() {
        warehouseController.getAllFromWarehouse();
    }

    private void getAllEmployee() {
        employeeController.getAllFromEmployee();
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setWarehouseController(WarehouseController warehouseController) {
        this.warehouseController = warehouseController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setIngredientController(IngredientController ingredientController) {
        this.ingredientController = ingredientController;
    }

    public void setDishIngredientController(DishIngredientController dishIngredientController) {
        this.dishIngredientController = dishIngredientController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void setMenuDishesController(MenuDishesController menuDishesController) {
        this.menuDishesController = menuDishesController;
    }

    public void setGuestOrderController(GuestOrderController guestOrderController) {
        this.guestOrderController = guestOrderController;
    }

    public void setDishCreatedController(DishCreatedController dishCreatedController) {
        this.dishCreatedController = dishCreatedController;
    }

    public void setDishOrderController(DishOrderController dishOrderController) {
        this.dishOrderController = dishOrderController;
    }
}
