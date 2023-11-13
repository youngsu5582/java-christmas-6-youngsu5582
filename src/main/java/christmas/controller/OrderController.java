package christmas.controller;

import christmas.domain.order.Bill;
import christmas.domain.order.Order;
import christmas.service.OrderService;
import christmas.view.InputView;
import christmas.view.OutputView;


public class OrderController {
    OrderService orderService = new OrderService();

    public Bill acceptOrder() {
        try {
            String orderInfo = InputView.inputOrder();
            Order order = orderService.takeOrder(orderInfo);
            Bill bill = orderService.processOrder(order);
            return bill;
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return acceptOrder();
        }
    }
}
