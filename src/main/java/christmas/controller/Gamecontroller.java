package christmas.controller;

import christmas.domain.Date;
import christmas.domain.order.Bill;
import christmas.view.OutputView;

public class Gamecontroller {
    private final DateController dateController = new DateController();
    private final OrderController orderController = new OrderController();

    public void run() {
        OutputView.printWelcomeMessage();
        Date date = confirmVisitDate();
        Bill bill = confirmOrder();
        printOrderResult(date, bill);
    }

    public Date confirmVisitDate() {
        Date date = dateController.acceptVisitDate();
        return date;
    }

    public Bill confirmOrder() {
        Bill bill = orderController.acceptOrder();
        return bill;
    }

    public void printOrderResult(Date date, Bill bill) {
        OutputView.printPreviewMessage(date);

        OutputView.printOrderMessage(bill);
    }
}
