package goit.jdbc.model.jdbc;

import goit.jdbc.model.Employee;
import goit.jdbc.model.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Splayd on 07.05.2017.
 */
public class JDBCEmployeeDao implements EmployeeDao {

    private DataSource dataSource;

    public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

    @Transactional(propagation = Propagation.MANDATORY)
    public Employee load(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID = ?")) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return createEmployee(resultSet);
            } else {
                throw new RuntimeException("Cannot find goit.jdbc.model.Employee with id " + id);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DataBase " + e);
            throw new RuntimeException(e);
        }
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public List<Employee> getAll() {
        List<Employee> result = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE");

            while (resultSet.next()) {
                Employee employee = createEmployee(resultSet);
                result.add(employee);
            }

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DataBase " + e);
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

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
