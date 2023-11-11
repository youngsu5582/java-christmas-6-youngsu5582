package christmas.domain.order;

import christmas.exception.OrderException;
import christmas.exception.ParserException;
import christmas.exception.message.OrderExceptionMessage;
import christmas.util.Parser;

import java.util.List;

import static christmas.constant.OrderConstant.MIN_AMOUNT;

public record RequestOrder(String orderName, int amount) {
    private static final String REQUEST_SEPERATOR = "-";

    public static RequestOrder of(String request) {
        List<String> parsedRequest = Parser.parseInfoWithSeparator(request, REQUEST_SEPERATOR);
        validate(parsedRequest);
        String orderName = parsedRequest.get(0);
        int amount = Parser.parseInfoToNumber(parsedRequest.get(1));
        return new RequestOrder(orderName, amount);
    }

    private static void validate(List<String> parsedRequest) {
        validateParsedRequestSize(parsedRequest.size());
        validateOrderName(parsedRequest.get(0));
        validateAmount(parsedRequest.get(1));
    }

    private static void validateOrderName(String orderNameInfo) {
        validateOrderNameIsValid(orderNameInfo);
    }

    private static void validateAmount(String amountInfo) {
        validateAmountInfoIsNumber(amountInfo);
        validateAmountIsInRange(Integer.parseInt(amountInfo));
    }

    private static void validateParsedRequestSize(int size) {
        if (size != 2) {
            throw new OrderException(OrderExceptionMessage.INVALID_FORMAT);
        }
    }

    private static void validateOrderNameIsValid(String orderName) {
        for (Character ch : orderName.toCharArray()) {
            if (isSpecial(ch)) {
                throw new OrderException(OrderExceptionMessage.INVALID_FORMAT);
            }
        }
    }

    private static boolean isSpecial(char ch) {
        return !Character.isAlphabetic(ch);
    }

    private static void validateAmountInfoIsNumber(String amountInfo) {
        try {
            Parser.parseInfoToNumber(amountInfo);
        } catch (ParserException exception) {
            throw new OrderException(OrderExceptionMessage.INVALID_FORMAT);
        }
    }

    private static void validateAmountIsInRange(int amount) {
        if (amount < MIN_AMOUNT) {
            throw new OrderException(OrderExceptionMessage.INVALID_AMOUNT);
        }
    }
}
