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

    List<Employee> getNames();

    Employee getById(Long id);

    Employee getByName(String name);

    Employee getBySurname(String surname);

    Employee getByNameAndSurname(String name, String surname);

    void remove(String name);
}
