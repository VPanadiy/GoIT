package dream.development.service;

import dream.development.dao.interfaces.EmployeeDao;
import dream.development.model.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Администратор on 14.08.2017.
 */
public class EmployeeService {

    private EmployeeDao employeeDao;

    @Transactional
    public List<Employee> getEmployees(){
        return employeeDao.getAll();
    }

    @Transactional
    public Employee getEmployeeByName(String employeeName) {
        return employeeDao.getByName(employeeName);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
