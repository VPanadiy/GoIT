package dream.application.model.controllers;

import dream.application.model.interfaces.GetAllQueryDao;
import dream.application.model.interfaces.GetAllWithConditionQueryDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * DishOrder Transaction Controller
 * Created by Splayd on 22.06.2017.
 */
public class DishOrderController {

    private GetAllQueryDao getAllQueryDao;
    private GetAllWithConditionQueryDao getAllWithConditionQueryDao;

    @Transactional
    public void getAllFromDishOrder() {
        getAllQueryDao.getAll();
    }

    @Transactional
    public void getAllWithConditionFromDishOrder() {
        getAllWithConditionQueryDao.getAllWithCondition();
    }

    public void setGetAllQueryDao(GetAllQueryDao getAllQueryDao) {
        this.getAllQueryDao = getAllQueryDao;
    }

    public void setGetAllWithConditionQueryDao(GetAllWithConditionQueryDao getAllWithConditionQueryDao) {
        this.getAllWithConditionQueryDao = getAllWithConditionQueryDao;
    }
}
