package dream.development.service;

import dream.development.dao.interfaces.MenuDao;
import dream.development.model.Menu;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Администратор on 15.08.2017.
 */
public class MenuService {

    private MenuDao menuDao;

    @Transactional
    public List<Menu> getMenu() {
        return menuDao.getAll();
    }

    @Transactional
    public List<Menu> getMenuName() {
        return menuDao.getAllName();
    }

    @Transactional
    public Menu getMenuById(Long id) {
        return menuDao.getById(id);
    }

    @Transactional
    public Menu getByName(String name) {
        return menuDao.getByName(name);
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
}
