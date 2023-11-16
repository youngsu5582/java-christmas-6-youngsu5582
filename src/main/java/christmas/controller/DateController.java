package christmas.controller;

import christmas.domain.date.Date;
import christmas.factory.ServiceFactory;
import christmas.service.DateService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class DateController {
    private DateService dateService = ServiceFactory.getDateService();

    public Date acceptVisitDate() {
        while (true) {
            try {
                String dateInfo = InputView.inputVisitDate();
                return dateService.createDate(dateInfo);
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception.getMessage());
            }
        }
    }

}
