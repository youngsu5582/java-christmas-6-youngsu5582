package christmas.controller;

import christmas.domain.order.Bill;
import christmas.domain.order.Order;
import christmas.exception.OrderException;
import christmas.factory.ServiceFactory;
import christmas.service.OrderService;
import christmas.view.InputView;
import christmas.view.OutputView;


public class OrderController {
    OrderService orderService = ServiceFactory.getOrderService();

    public Bill acceptOrder() {
        while (true) {
            try {
                String orderInfo = InputView.inputOrder();
                Order order = orderService.takeOrder(orderInfo);
                Bill bill = orderService.processOrder(order);
                return bill;
            } catch (OrderException exception) {
                OutputView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
