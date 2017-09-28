package goit.jdbc;

import goit.jdbc.model.jdbc.JDBCEmployeeDao;
import goit.jdbc.model.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Splayd on 07.05.2017.
 */
public class JDBC_main {

    public static final Logger LOGGER = LoggerFactory.getLogger(JDBC_main.class);

    public static void main(String[] args) {
        EmployeeDao employeeDao = new JDBCEmployeeDao();

        System.out.println("All goit.jdbc.model.Employee");
        employeeDao.getAll().forEach(System.out::println);

        System.out.println("goit.jdbc.model.Employee with id 1");
        System.out.println(employeeDao.load(1));
    }
}
