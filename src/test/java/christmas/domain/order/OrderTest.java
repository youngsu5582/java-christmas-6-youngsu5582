package christmas.domain.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import christmas.domain.order.Order;
import christmas.domain.order.RequestOrder;
import christmas.exception.OrderException;
import christmas.exception.message.OrderExceptionMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderTest {
    @Test
    @DisplayName("정해진 형식에 맞는 메뉴 요청 리스트 문자열 을 입력 하면 Order 를 만든다.")
    void createOrderWithFormattedRequests() {
        String requestInfo = "양송이수프-3,초코케이크-2";
        Order order = Order.of(requestInfo);
        Assertions.assertEquals(order.requestOrders().size(), 2);
    }

    @ParameterizedTest
    @DisplayName("정해진 형식에 맞지 않는 문자열 을 입력 하면 예외를 발생 한다.")
    @ValueSource(strings = {"양송이수프-3.초코케이크-2", "양송이수프-2...초코케이크-3", "초코.케이크-2"})
    void throwExceptionWhenRequestsIsInValid(String invalidRequestInfo) {
        assertThatThrownBy(() -> RequestOrder.of(invalidRequestInfo))
                .isInstanceOf(OrderException.class)
                .hasMessageContaining(OrderExceptionMessage.INVALID_FORMAT.getMessage());
    }

    @Test
    @DisplayName("중복된 메뉴명 이 있으면 예외를 발생 한다.")
    void throwExceptionWhenInputDuplicatedOrderName() {
        String duplicateInfo = "양송이수프-3,초코케이크-2,양송이수프-2";
        assertThatThrownBy(() -> Order.of(duplicateInfo))
                .isInstanceOf(OrderException.class)
                .hasMessageContaining(OrderExceptionMessage.INVALID_FORMAT.getMessage());
    }
}
