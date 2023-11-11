package christmas.exception;

import christmas.exception.message.DateExceptionMessage;
import christmas.lib.exception.CustomException;

public class DateException extends CustomException {
    public DateException(DateExceptionMessage errorMessage){
        super(errorMessage.getMessage());
    }
}
