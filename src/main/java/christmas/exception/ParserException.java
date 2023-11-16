package christmas.exception;

import christmas.exception.message.ParserExceptionMessage;
import christmas.lib.exception.CustomException;

public class ParserException extends CustomException {
    public ParserException(ParserExceptionMessage errorMessage){
        super(errorMessage.getMessage());
    }
}
