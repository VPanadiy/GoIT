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
    public List<Employee> getEmployeesNames(){
        return employeeDao.getNames();
    }

    @Transactional
    public Employee getEmployeeByName(String employeeName) {
        return employeeDao.getByName(employeeName);
    }

    @Transactional
    public Employee getEmployeeBySurname(String employeeSurname) {
        return employeeDao.getBySurname(employeeSurname);
    }

    @Transactional
    public Employee getEmployeeByNameAndSurname(String employeeName, String employeeSurname) {
        return employeeDao.getByNameAndSurname(employeeName, employeeSurname);
    }

    @Transactional
    public Employee getEmployeeById(Long id) {
        return employeeDao.getById(id);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
