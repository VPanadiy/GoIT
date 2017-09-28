package dream.application.model.controllers;

import dream.application.model.interfaces.*;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

/**
 * MenuDishes Transaction Controller
 * Created by Splayd on 10.06.2017.
 */
public class MenuDishesController {

    private GetByIdDao getByIdDao;
    private GetTotalRowDao getTotalRowDao;
    private InsertQueryDao insertQueryDao;
    private RemoveByIdQueryDao removeByIdQueryDao;
    private RemoveByNameQueryDao removeByNameQueryDao;
    private GetAllQueryDao getAllQueryDao;
    private UpdateQueryDao updateQueryDao;

    @Transactional
    public void updateIngredientsInMenu() {
        updateQueryDao.update();
    }

    @Transactional
    public Integer getMenuDishesTotalRow() {
        return getTotalRowDao.getTotalRow();
    }

    @Transactional
    public List getMenuDishesById(int id) {
        return getByIdDao.getById(id);
    }

    @Transactional
    public void insertMenuDishes() throws ParseException {
        insertQueryDao.insert();
    }

    @Transactional
    public void removeMenuDishes(int id) {
        removeByIdQueryDao.removeById(id);
    }

    @Transactional
    public void removeMenuDishesByName(String name) {
        removeByNameQueryDao.removeByName(name);
    }

    @Transactional
    public void getAllFromMenuDishes() {
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

    public void setRemoveByIdQueryDao(RemoveByIdQueryDao removeByIdQueryDao) {
        this.removeByIdQueryDao = removeByIdQueryDao;
    }

    public void setGetAllQueryDao(GetAllQueryDao getAllQueryDao) {
        this.getAllQueryDao = getAllQueryDao;
    }

    public void setUpdateQueryDao(UpdateQueryDao updateQueryDao) {
        this.updateQueryDao = updateQueryDao;
    }

    public void setRemoveByNameQueryDao(RemoveByNameQueryDao removeByNameQueryDao) {
        this.removeByNameQueryDao = removeByNameQueryDao;
    }
}
