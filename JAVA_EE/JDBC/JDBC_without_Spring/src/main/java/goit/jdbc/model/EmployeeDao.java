package goit.jdbc.model;

import java.util.List;

/**
 * Created by Splayd on 07.05.2017.
 */
public interface EmployeeDao {

    Employee load(int id);

    List<Employee> getAll();
}
