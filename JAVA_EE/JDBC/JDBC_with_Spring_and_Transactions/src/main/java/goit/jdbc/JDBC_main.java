package goit.jdbc;

import goit.jdbc.controllers.EmployeeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Splayd on 07.05.2017.
 */
public class JDBC_main {

    public static final Logger LOGGER = LoggerFactory.getLogger(JDBC_main.class);

    private EmployeeController employeeController;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        JDBC_main main = context.getBean(JDBC_main.class);
        main.start();
    }

    private void start() {
        employeeController.getAllEmployee().forEach(System.out::println);
        System.out.println(employeeController.getEmployeeById(1));
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
}
