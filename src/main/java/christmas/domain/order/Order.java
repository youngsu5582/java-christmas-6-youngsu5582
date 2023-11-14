package christmas.domain.order;

import static christmas.constant.OrderConstant.ORDER_SEPARATOR;

import christmas.exception.OrderException;
import christmas.exception.message.OrderExceptionMessage;
import christmas.util.Parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Order(List<RequestOrder> requestOrders) {
    private static final String SEPARATOR = ORDER_SEPARATOR;

    public static Order of(String requestOrderInfo) {
        List<String> parsedRequestOrderInfo = Parser.parseInfoWithSeparator(requestOrderInfo, SEPARATOR);

        List<RequestOrder> requestOrders = confirmRequestOrders(parsedRequestOrderInfo);

        validate(requestOrders);
        return new Order(requestOrders);
    }

    private static List<RequestOrder> confirmRequestOrders(List<String> parsedRequestInfo) {
        List<RequestOrder> requestOrders = new ArrayList<>();

        for (String requestInfo : parsedRequestInfo) {
            requestOrders.add(RequestOrder.of(requestInfo));
        }
        return requestOrders;
    }

    private static void validate(List<RequestOrder> requestOrders) {
        validateOrderNameDuplicated(requestOrders);
    }

    private static void validateOrderNameDuplicated(List<RequestOrder> requestOrders) {
        Set<String> uniqueOrderNames = new HashSet<>();
        for (RequestOrder requestOrder : requestOrders) {
            if (!uniqueOrderNames.add(requestOrder.orderName())) {
                throw new OrderException(OrderExceptionMessage.INVALID_FORMAT);
            }
        }
    }
}
