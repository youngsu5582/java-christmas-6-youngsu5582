package christmas.domain;

import christmas.domain.category.Drink;
import christmas.domain.menu.Category;
import christmas.domain.order.OrderResult;
import christmas.exception.OrderException;
import christmas.exception.message.OrderExceptionMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderResultTest {
    @Test
    @DisplayName("메뉴명 과 개수를 입력하면 주문을 접수한다.")
    void createOrderResult() {
        String orderName = "제로콜라";
        int amountCount = 4;
        OrderResult orderResult = OrderResult.of(orderName, amountCount);
        Assertions.assertEquals(orderResult.orderInfo().amount(), amountCount);
        Assertions.assertEquals(orderResult.orderInfo().menu(), Drink.ZERO_COKE.get());
        Assertions.assertEquals(orderResult.category(), Category.DRINK);
    }
    @Test
    @DisplayName("없는 메뉴명을 입력하면 예외를 발생한다.")
    void throwExceptionWhenInputNotExistMenuName(){
        String orderName = "제로콜리";
        int amountCount = 4;
        assertThatThrownBy(()->OrderResult.of(orderName,amountCount))
                .isInstanceOf(OrderException.class)
                .hasMessageContaining(OrderExceptionMessage.INVALID_FORMAT.getMessage());
    }
}
