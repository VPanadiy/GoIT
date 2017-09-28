package dream.development.dao.interfaces;

import dream.development.model.Dish;

import java.util.List;

/**
 * Dish Interface
 * Created by Splayd on 27.06.2017.
 */
public interface DishDao {

    void insert(Dish dish);

    List<Dish> getAll();

    List<Dish> getByNameValue(String nameValue);

    Dish getById(Long id);

    Dish getByName(String name);

    void remove(String name);
}
