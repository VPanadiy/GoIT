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
    public List<Menu> getMenu(){
        return menuDao.getAll();
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
}
