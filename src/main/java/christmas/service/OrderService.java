package christmas.service;

import christmas.domain.order.Bill;
import christmas.domain.order.Order;
import christmas.domain.order.RequestOrder;
import christmas.exception.OrderException;
import christmas.exception.ParserException;
import christmas.exception.message.OrderExceptionMessage;

import java.util.List;

public class OrderService {
    public Order takeOrder(String orderInfo){
        try{
            Order order = Order.of(orderInfo);
            return order;
        }catch (ParserException exception){
            throw new OrderException(OrderExceptionMessage.INVALID_FORMAT,exception);
        }

    }
    public Bill processOrder(Order order){
        List<RequestOrder> requestOrders = order.requestOrders();
        Bill bill = Bill.of(requestOrders);
        return bill;
    }
}
