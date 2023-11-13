package christmas.controller;

import christmas.domain.order.Bill;
import christmas.domain.order.Order;
import christmas.domain.order.RequestOrder;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.view.message.OutputViewMessage;

import java.util.List;

public class OrderController {
    public Bill processOrder(){
        try {
            String orderInfo = InputView.inputOrder();
            Order order = takeOrder(orderInfo);
            Bill bill = confirmOrder(order);
            return bill;
        }catch (IllegalArgumentException exception){
            OutputView.printErrorMessage(exception.getMessage());
            return processOrder();
        }
    }

    private Order takeOrder(String orderInfo){
        Order order = Order.of(orderInfo);
        return order;
    }
    private Bill confirmOrder(Order order){
        List<RequestOrder> requestOrders = order.requestOrders();
        Bill bill = Bill.of(requestOrders);
        return bill;
    }
}
