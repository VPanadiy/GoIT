package dream.development.web;

import dream.development.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Администратор on 25.08.2017.
 */

@Controller
public class DishController {

    private DishService dishService;

    @RequestMapping(value = "/dish/{dishName}", method = RequestMethod.GET)
    public ModelAndView dish(@PathVariable String dishName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dish",dishService.getDishByName(dishName));
        modelAndView.setViewName("dish");
        return modelAndView;
    }

    @RequestMapping(value = "/searchPage", method = RequestMethod.POST)
    public ModelAndView searchPage(@RequestParam("searchButton") String searchString){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dishes",dishService.getDishesByValue(searchString));
        modelAndView.setViewName("searchPage");
        return modelAndView;
    }

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }
}
