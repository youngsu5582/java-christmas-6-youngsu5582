package christmas.exception;

import christmas.exception.message.DayOfWeekExceptionMessage;
import christmas.lib.exception.CustomException;

public class DayOfWeekException extends CustomException {
    public DayOfWeekException(DayOfWeekExceptionMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
