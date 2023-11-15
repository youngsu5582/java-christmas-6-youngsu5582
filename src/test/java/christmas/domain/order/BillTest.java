package christmas.domain.order;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.domain.order.Bill;
import christmas.domain.order.RequestOrder;
import christmas.exception.OrderException;
import christmas.exception.message.OrderExceptionMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BillTest {
    @Test
    @DisplayName("주문 리스트를 입력하면 주문을 접수한다.")
    void createOrderWithFormattedRequests() {
        List<RequestOrder> requestOrderList =
                List.of(new RequestOrder("레드와인", 2),
                        new RequestOrder("시저샐러드", 1));
        Bill bill = Bill.of(requestOrderList);
        Assertions.assertEquals(128000, bill.totalPrice());
    }

    @Test
    @DisplayName("총 주문 개수가 최대 주문 개수를 초과하면 예외 발생한다.")
    void throwExceptionWhenAmountIsOverall() {
        List<RequestOrder> requestOrderList =
                List.of(new RequestOrder("레드와인", 21));
        assertThatThrownBy(() -> Bill.of(requestOrderList)).
                isInstanceOf(OrderException.class)
                .hasMessageContaining(OrderExceptionMessage.OVERALL_ORDER_COUNT.getMessage());
    }

    @Test
    @DisplayName("음료 메뉴만 주문하면 예외를 발생한다.")
    void throwExceptionWhenOrderIsOnlyDrink() {
        List<RequestOrder> requestOrderList =
                List.of(new RequestOrder("레드와인", 2),
                        new RequestOrder("샴페인", 1));
        assertThatThrownBy(() -> Bill.of(requestOrderList)).
                isInstanceOf(OrderException.class)
                .hasMessageContaining(OrderExceptionMessage.ONLY_DRINK.getMessage());
    }
}