package dream.application.model.jdbc;

import dream.application.model.impl.GuestOrder;
import dream.application.model.interfaces.*;
import dream.application.model.mapper.GuestOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * JDBC GUEST ORDER DAO
 * Created by Splayd on 17.06.2017.
 */
public class JDBCGuestOrderDao implements GetAllQueryDao, GetByIdDao,UpdateQueryDao, GetByNameDao, InsertQueryDao, GetTotalRowDao, RemoveByIdQueryDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private JDBCEmployeeDao jdbcEmployeeDao;
    private JDBCDishOrderDao jdbcDishOrderDao;

    private GuestOrder guestOrder;

    public JDBCGuestOrderDao(GuestOrder guestOrder) {
        this.guestOrder = guestOrder;
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(JDBCGuestOrderDao.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void getAll() {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM GUEST_ORDER";

        List<GuestOrder> guestOrderList =
                this.jdbcTemplate.query(sql,
                        new GuestOrderMapper());

        for (GuestOrder guestOrder : guestOrderList) {
            System.out.println(guestOrder);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void insert() throws ParseException {
        jdbcTemplate = new JdbcTemplate(dataSource);
        Scanner scanner = new Scanner(System.in);

        String sql = "INSERT INTO GUEST_ORDER VALUES(?,?,?,?,?)";

        int orderNum = getTotalRow() + 1;
        System.out.println("Enter table number: ");
        int tableNum = scanner.nextInt();
        scanner.nextLine();
        Date today = Date.valueOf(LocalDate.now());
        System.out.println("Enter name of employee, that took order: ");
        String employeeName = scanner.nextLine();
        boolean status = false;

        List<String> employeeList = new ArrayList<String>();
        employeeList.add(jdbcEmployeeDao.getByName(employeeName).get(0).toString());
        if (!employeeList.get(0).equals("")) {
            String beginNumString = "id=";
            String endNumString = ", surname=";
            int beginNumParse = employeeList.get(0).lastIndexOf(beginNumString) + beginNumString.length();
            int endNumParse = employeeList.get(0).indexOf(endNumString);

            for (String employees : employeeList) {
                int employeeId = Integer.parseInt(employees.substring(beginNumParse, endNumParse));
                jdbcTemplate.update(sql, orderNum, tableNum, today, employeeId, status);
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List getByName(String name) {
        jdbcTemplate = new JdbcTemplate(dataSource);

        boolean status = Boolean.parseBoolean(name);

        String sql = "SELECT * FROM GUEST_ORDER WHERE ISCLOSED = ?";

        List<GuestOrder> guestOrderList =
                this.jdbcTemplate.query(sql,
                        new GuestOrderMapper(), status);

        for (GuestOrder guestOrder : guestOrderList) {
            System.out.println(guestOrder);
        }
        return guestOrderList;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeById(int id) {
        jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcDishOrderDao.removeById(id);

        String sql = "DELETE FROM GUEST_ORDER WHERE GUEST_ORDER.ID = ?";

        checkOrderStatus(id, sql);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void update() {
        Scanner scanner = new Scanner(System.in);
        jdbcTemplate = new JdbcTemplate(dataSource);

        System.out.println("Enter order id to close: ");
        int id = scanner.nextInt();
        scanner.close();

        String sql = "UPDATE GUEST_ORDER SET isClosed = true WHERE id = ?";

        checkOrderStatus(id, sql);
    }

    private void checkOrderStatus(int id, String sql) {
        List<String> orderList = new ArrayList<>();
        orderList.add(getById(id).get(0).toString());
        if (!orderList.get(0).equals("")) {
            String beginNumString = "isClosed=";
            String endNumString = "}]";
            int beginNumParse = orderList.get(0).lastIndexOf(beginNumString) + beginNumString.length();
            int endNumParse = orderList.get(0).indexOf(endNumString);

            for (String employees : orderList) {
                boolean orderStatus = Boolean.parseBoolean(employees.substring(beginNumParse, endNumParse));
                if (!orderStatus) {
                    jdbcTemplate.update(sql, id);
                } else {
                    System.out.println("Order status is closed!");
                }
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List getById(int id) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        List<String> orderResultList = new ArrayList<>();

        String sql = "SELECT * FROM GUEST_ORDER WHERE ID = ?";

        List<GuestOrder> guestOrderList =
                this.jdbcTemplate.query(sql,
                        new GuestOrderMapper(), id);

        orderResultList.add(guestOrderList.toString());

        return orderResultList;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Integer getTotalRow() {
        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT COUNT(GUEST_ORDER.ID) FROM GUEST_ORDER";

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public GuestOrder getGuestOrder() {
        return guestOrder;
    }

    public void setJdbcEmployeeDao(JDBCEmployeeDao jdbcEmployeeDao) {
        this.jdbcEmployeeDao = jdbcEmployeeDao;
    }

    public void setJdbcDishOrderDao(JDBCDishOrderDao jdbcDishOrderDao) {
        this.jdbcDishOrderDao = jdbcDishOrderDao;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
