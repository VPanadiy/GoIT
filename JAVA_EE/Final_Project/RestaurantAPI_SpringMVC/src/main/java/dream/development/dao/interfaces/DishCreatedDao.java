package dream.development.dao.interfaces;

import dream.development.model.DishCreated;
import dream.development.model.Orders;

import java.util.List;

/**
 * Dish Created Interface
 * Created by Splayd on 23.07.2017.
 */
public interface DishCreatedDao {

    void insert(DishCreated createdDishes);

    List<DishCreated> getAll();

    void remove(Orders order);
}
