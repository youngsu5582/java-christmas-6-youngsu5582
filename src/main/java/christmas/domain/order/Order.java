package christmas.domain.order;

import christmas.domain.menu.Menu;
import christmas.exception.OrderException;
import christmas.exception.message.OrderExceptionMessage;
import christmas.util.Parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Order(List<RequestOrder> requestOrders) {
    private static final String ORDER_SEPERATOR = ",";

    public static Order of(String requestOrderInfo) {
        List<RequestOrder> requestOrders = new ArrayList<>();
        List<String> parsedRequestInfo = Parser.parseInfoWithSeparator(requestOrderInfo, ORDER_SEPERATOR);
        for (String requestInfo : parsedRequestInfo) {
            requestOrders.add(RequestOrder.of(requestInfo));
        }
        validate(requestOrders);
        return new Order(requestOrders);
    }

    private static void validate(List<RequestOrder> requestOrders) {
        validateOrderNameDuplicated(requestOrders);
    }

    private static void validateOrderNameDuplicated(List<RequestOrder> requestOrders) {
        Set<String> uniqueOrderNames = new HashSet<>();
        for (RequestOrder requestOrder : requestOrders) {
            if (!uniqueOrderNames.add(requestOrder.orderName())) {
                throw new OrderException(OrderExceptionMessage.DUPLICATE_MENU);
            }
        }
    }
}
