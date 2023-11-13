package christmas.service;

import christmas.domain.order.Bill;
import christmas.domain.order.Order;
import christmas.domain.order.RequestOrder;

import java.util.List;

public class OrderService {
    public Order takeOrder(String orderInfo){
        Order order = Order.of(orderInfo);
        return order;
    }
    public Bill processOrder(Order order){
        List<RequestOrder> requestOrders = order.requestOrders();
        Bill bill = Bill.of(requestOrders);
        return bill;
    }
}
