package dream.application.model.jdbc;

import dream.application.model.impl.Employee;
import dream.application.model.interfaces.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * JDBC EMPLOYEE DAO
 * Created by Splayd on 09.05.2017.
 */
public class JDBCEmployeeDao implements GetAllQueryDao, GetByIdDao,GetByNameDao, RemoveByNameQueryDao, InsertQueryDao, GetTotalRowDao {

    private final Employee employee;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public JDBCEmployeeDao(Employee employee) {
        this.employee = employee;
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(JDBCEmployeeDao.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void insert() throws ParseException {
        jdbcTemplate = new JdbcTemplate(dataSource);

        Scanner scanner = new Scanner(System.in);
        int num = getTotalRow() + 1;
        System.out.println("Enter surname: ");
        String surname = scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter date birth: ");
        String date_birth = scanner.next();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(date_birth);
        scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.println("Enter appointment: ");
        String appointment = scanner.nextLine();
        System.out.println("Enter salary: ");
        float salary = scanner.nextFloat();
        scanner.nextLine();
        scanner.close();

        String sql = "INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql, num, surname, name, date, phone, appointment, salary);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeByName(String name) {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEE.NAME = ?";

        jdbcTemplate.update(sql, name);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List getByName(String name) {
        List<String> resultEmployee = new ArrayList<String>();
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE.NAME = ?";
        List<JDBCEmployeeDao> employeeList = jdbcTemplate.query(sql,
                (rs, arg1) -> {
                    return getJdbcEmployeeDao(rs);
                }, name);
        employeeList.forEach(result -> {
            Employee employee = result.getEmployee();
            resultEmployee.add("id=" + employee.getId() + ", surname='" + employee.getSurname() + "', name='" + employee.getName() + "', dateBirth=" + employee.getDateBirth() + ", phoneNumber='" + employee.getPhoneNumber() + "', appointment='" + employee.getAppointment() + "', salary=" + employee.getSalary());
        });
        return resultEmployee;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void getAll() {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM EMPLOYEE";
        List<JDBCEmployeeDao> employeeList = jdbcTemplate.query(sql,
                (rs, arg1) -> {
                    return getJdbcEmployeeDao(rs);
                });
        employeeList.forEach(result -> {
            Employee employee = result.getEmployee();
            System.out.println(employee);
        });
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List getById(int id) {
        List<String> resultEmployee = new ArrayList<String>();
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE.ID = ?";
        List<JDBCEmployeeDao> employeeList = jdbcTemplate.query(sql,
                (rs, arg1) -> {
                    return getJdbcEmployeeDao(rs);
                }, id);
        employeeList.forEach(result -> {
            Employee employee = result.getEmployee();
            resultEmployee.add("id=" + employee.getId() + ", surname='" + employee.getSurname() + "', name='" + employee.getName() + "', dateBirth=" + employee.getDateBirth() + ", phoneNumber='" + employee.getPhoneNumber() + "', appointment='" + employee.getAppointment() + "', salary=" + employee.getSalary());
        });
        return resultEmployee;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Integer getTotalRow() {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT COUNT(*) FROM EMPLOYEE";

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    private JDBCEmployeeDao getJdbcEmployeeDao(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("ID"));
        employee.setSurname(rs.getString("SURNAME"));
        employee.setName(rs.getString("NAME"));
        employee.setDateBirth(rs.getDate("DATE_BIRTH").toLocalDate());
        employee.setPhoneNumber(rs.getString("PHONE_NUMBER"));
        employee.setAppointment(rs.getString("APPOINTMENT"));
        employee.setSalary(rs.getFloat("SALARY"));
        return new JDBCEmployeeDao(employee);
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Employee getEmployee() {
        return employee;
    }
}