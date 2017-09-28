package goit.jdbc.model.jdbc;

import goit.jdbc.model.Employee;
import goit.jdbc.model.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Splayd on 07.05.2017.
 */
public class JDBCEmployeeDao implements EmployeeDao {

    public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);
    private String url = "jdbc:postgresql://localhost:5432/company";
    private String user = "user";
    private String password = "user";

    public JDBCEmployeeDao() {
        loadDriver();
    }

    public Employee load(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID = ?")) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return createEmployee(resultSet);
            } else {
                throw new RuntimeException("Cannot find goit.jdbc.model.Employee with id " + id);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DataBase " + url, e);
            throw new RuntimeException(e);
        }
    }

    public List<Employee> getAll() {
        List<Employee> result = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE");

            while (resultSet.next()) {
                Employee employee = createEmployee(resultSet);
                result.add(employee);
            }

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DataBase " + url, e);
            throw new RuntimeException(e);
        }
        return result;
    }

    private Employee createEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("ID"));
        employee.setName(resultSet.getString("NAME"));
        employee.setAge(resultSet.getInt("AGE"));
        employee.setAddress(resultSet.getString("ADDRESS"));
        employee.setSalary(resultSet.getFloat("SALARY"));
        employee.setJoinDate(resultSet.getString("JOIN_DATE"));
        return employee;
    }

    private void loadDriver() {
        try {
            LOGGER.info("Loading JDBC driver: org.postgresql.Driver");
            Class.forName("org.postgresql.Driver");
            LOGGER.info("Loading driver successful");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Cannot find driver: org.postgresql.Driver");
            throw new RuntimeException(e);
        }
    }
}
