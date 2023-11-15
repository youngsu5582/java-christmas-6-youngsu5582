package christmas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import christmas.domain.order.RequestOrder;
import christmas.exception.OrderException;
import christmas.exception.message.OrderExceptionMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RequestOrderTest {
    @Test
    @DisplayName("정해진 형식에 맞는 메뉴 요청(양송이수프-3)을 입력하면 RequestOrder 를 만든다.")
    void createRequestOrderWithFormattedRequest() {
        String requestInfo = "양송이수프-3";
        RequestOrder requestOrder = RequestOrder.of(requestInfo);
        Assertions.assertEquals(requestOrder.orderName(), "양송이수프");
        Assertions.assertEquals(requestOrder.amount(), 3);
    }

    @ParameterizedTest
    @DisplayName("정해진 형식에 맞지 않는 문자열을 입력하면 예외를 발생한다.")
    @ValueSource(strings = {"양송이수프!-3", "양송이수프--3", "양송이수프3개,양송이수프-a"})
    void throwExceptionWhenRequestIsInValid(String invalidRequestInfo) {
        assertThatThrownBy(() -> RequestOrder.of(invalidRequestInfo))
                .isInstanceOf(OrderException.class)
                .hasMessageContaining(OrderExceptionMessage.INVALID_FORMAT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("1보다 작은 값을 입력하면 예외를 발생한다.")
    @ValueSource(strings = {"양송이수프-0"})
    void throwExceptionWhenAmountOutBound(String invalidAmountRequestInfo) {
        assertThatThrownBy(() -> RequestOrder.of(invalidAmountRequestInfo))
                .isInstanceOf(OrderException.class)
                .hasMessageContaining(OrderExceptionMessage.INVALID_FORMAT.getMessage());
    }
}
