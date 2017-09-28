package dream.development.web;

import dream.development.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by Администратор on 14.08.2017.
 */

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ModelAndView employees(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employees", employeeService.getEmployees());
        modelAndView.setViewName("employees");
        return modelAndView;
    }

    @RequestMapping(value = "/personal", method = RequestMethod.GET)
    public ModelAndView personal(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("personal", employeeService.getEmployees());
        modelAndView.setViewName("personal");
        return modelAndView;
    }

    @RequestMapping(value = "/employee/{employeeName}", method = RequestMethod.GET)
    public ModelAndView employee(@PathVariable String employeeName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee",employeeService.getEmployeeByName(employeeName));
        modelAndView.setViewName("employee");
        return modelAndView;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
