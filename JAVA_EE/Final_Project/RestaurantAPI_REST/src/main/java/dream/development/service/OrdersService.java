package dream.development.service;

import dream.development.dao.interfaces.OrdersDao;
import dream.development.model.Orders;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Администратор on 01.09.2017.
 */
public class OrdersService {

    private OrdersDao ordersDao;

    @Transactional
    public List<Orders> getOrders() {
        return ordersDao.getAll();
    }

    @Transactional
    public List<Orders> getOpenedOrders() {
        return ordersDao.getOpened();
    }

    @Transactional
    public List<Orders> getClosedOrders() {
        return ordersDao.getClosed();
    }

    @Transactional
    public Orders getOrdersById(Long id) {
        return ordersDao.getById(id);
    }

    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }
}
