package dream.development.web;

import dream.development.model.Menu;
import dream.development.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Администратор on 26.08.2017.
 */

@RestController
public class MenuController {

    private MenuService menuService;

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public List<Menu> menuNames() {
        return menuService.getMenuName();
    }

    @RequestMapping(value = "/menu/id/{menuId}", method = RequestMethod.GET)
    public Menu menuById(@PathVariable Long menuId) {
        return menuService.getMenuById(menuId);
    }

    @RequestMapping(value = "/menu/name/{name}", method = RequestMethod.GET)
    public Menu menu(@PathVariable String name) {
        return menuService.getByName(name);
    }

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }
}
