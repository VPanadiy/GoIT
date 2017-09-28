package dream.development.web;

import dream.development.model.Orders;
import dream.development.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Администратор on 01.09.2017.
 */

@RestController
public class OrdersController {

    private OrdersService ordersService;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public List<Orders> ordersList() {
        return ordersService.getOrders();
    }

    @RequestMapping(value = "/order/opened", method = RequestMethod.GET)
    public List<Orders> openedOrdersList() {
        return ordersService.getOpenedOrders();
    }

    @RequestMapping(value = "/order/closed", method = RequestMethod.GET)
    public List<Orders> closedOrdersList() {
        return ordersService.getClosedOrders();
    }

    @RequestMapping(value = "/order/id/{orderId}", method = RequestMethod.GET)
    public Orders menuById(@PathVariable Long orderId) {
        return ordersService.getOrdersById(orderId);
    }

    @Autowired
    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }
}
