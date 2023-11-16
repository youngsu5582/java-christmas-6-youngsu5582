package christmas.exception;

import christmas.exception.message.DateExceptionMessage;
import christmas.lib.exception.CustomException;

public class DateException extends CustomException {
    public DateException(DateExceptionMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public DateException(DateExceptionMessage errorMessage, Exception exception) {
        super(errorMessage.getMessage(), exception);
    }
}