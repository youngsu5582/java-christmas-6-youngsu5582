package christmas.controller;

import christmas.domain.Date;
import christmas.view.OutputView;

public class Gamecontroller {
    private final DateController dateController = new DateController();

    public void run() {
        OutputView.printWelcomeMessage();
        confirmVisitDate();
    }

    public Date confirmVisitDate() {
        Date date = dateController.acceptVisitDate();
        return date;
    }
}
