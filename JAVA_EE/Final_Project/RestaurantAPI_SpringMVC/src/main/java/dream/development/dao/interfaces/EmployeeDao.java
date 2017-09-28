package dream.development.dao.interfaces;

import dream.development.model.Employee;

import java.util.List;

/**
 * Employee Interface
 * Created by Splayd on 27.06.2017.
 */
public interface EmployeeDao {

    void insert(Employee employee);

    List<Employee> getAll();

    Employee getById(Long id);

    Employee getByName(String name);

    void remove(String name);
}
