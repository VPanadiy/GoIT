package dream.development.service;

import dream.development.dao.interfaces.DishDao;
import dream.development.model.Dish;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Администратор on 24.08.2017.
 */
public class DishService {

    private DishDao dishDao;

    @Transactional
    public List<Dish> getDishes() {
        return dishDao.getAll();
    }

    @Transactional
    public Dish getDishByName(String dishName) {
        return dishDao.getByName(dishName);
    }

    @Transactional
    public List<Dish> getDishesByValue(String nameValue) {
        return dishDao.getByNameValue(nameValue);
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
