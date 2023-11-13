package christmas.controller;

import christmas.domain.Date;
import christmas.service.DateService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class DateController {
    private DateService dateService = new DateService();
    public Date acceptVisitDate() {
        try {
            String dateInfo = InputView.inputVisitDate();
            return dateService.createDate(dateInfo);
        }catch (IllegalArgumentException exception){
            OutputView.printErrorMessage(exception.getMessage());
            return acceptVisitDate();
        }
    }
}
