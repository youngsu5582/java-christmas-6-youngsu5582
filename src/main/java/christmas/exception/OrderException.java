package christmas.exception;

import christmas.exception.message.OrderExceptionMessage;
import christmas.lib.exception.CustomException;

public class OrderException extends CustomException {
    public OrderException(OrderExceptionMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
