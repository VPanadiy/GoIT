package dream.application.model.controllers;

import dream.application.model.interfaces.GetAllQueryDao;
import dream.application.model.interfaces.GetByIdDao;
import dream.application.model.interfaces.GetTotalRowDao;
import dream.application.model.interfaces.InsertQueryDao;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

/**
 * DishIngredient Transaction Controller
 * Created by Splayd on 05.06.2017.
 */
public class DishIngredientController {

    private GetByIdDao getByIdDao;
    private GetTotalRowDao getTotalRowDao;
    private InsertQueryDao insertQueryDao;
    private GetAllQueryDao getAllQueryDao;

    @Transactional
    public Integer getIngredientTotalRow() {
        return getTotalRowDao.getTotalRow();
    }

    @Transactional
    public List getDishIngredientById(int id) {
        return getByIdDao.getById(id);
    }

    @Transactional
    public void insertDishIngredient() throws ParseException {
        insertQueryDao.insert();
    }

    @Transactional
    public void getAllFromDishIngredient() {
        getAllQueryDao.getAll();
    }

    public void setGetTotalRowDao(GetTotalRowDao getTotalRowDao) {
        this.getTotalRowDao = getTotalRowDao;
    }

    public void setGetByIdDao(GetByIdDao getByIdDao) {
        this.getByIdDao = getByIdDao;
    }

    public void setInsertQueryDao(InsertQueryDao insertQueryDao) {
        this.insertQueryDao = insertQueryDao;
    }

    public void setGetAllQueryDao(GetAllQueryDao getAllQueryDao) {
        this.getAllQueryDao = getAllQueryDao;
    }
}
