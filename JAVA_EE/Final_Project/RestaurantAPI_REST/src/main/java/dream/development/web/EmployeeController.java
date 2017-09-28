package dream.development.web;

import dream.development.model.Employee;
import dream.development.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by Администратор on 14.08.2017.
 */

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @RequestMapping(value = {"/employee", "/personal"}, method = RequestMethod.GET)
    public List<Employee> employee() {
        return employeeService.getEmployees();
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> employeeNames() {
        return employeeService.getEmployeesNames();
    }

    @RequestMapping(value = "/employee/name/{employeeName}", method = RequestMethod.GET)
    public Employee employeeName(@PathVariable String employeeName) {
        return employeeService.getEmployeeByName(employeeName);
    }

    @RequestMapping(value = "/employee/surname/{employeeSurname}", method = RequestMethod.GET)
    public Employee employeeSurname(@PathVariable String employeeSurname) {
        return employeeService.getEmployeeBySurname(employeeSurname);
    }

    @RequestMapping(value = "/employee/nameAndSurname/{employeeName}/{employeeSurname}", method = RequestMethod.GET)
    public Employee employeeNameAndSurname(@PathVariable String employeeName, @PathVariable String employeeSurname) {
        return employeeService.getEmployeeByNameAndSurname(employeeName, employeeSurname);
    }

    @RequestMapping(value = "/employee/id/{employeeId}", method = RequestMethod.GET)
    public Employee employeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
