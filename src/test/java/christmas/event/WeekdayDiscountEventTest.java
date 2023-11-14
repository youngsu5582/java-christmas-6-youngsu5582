package christmas.event;

import christmas.constant.EventConstant;
import christmas.domain.Date;
import christmas.domain.order.Bill;
import christmas.domain.order.RequestOrder;
import christmas.event.discount.WeekdayDiscountEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WeekdayDiscountEventTest {
    WeekdayDiscountEvent event = new WeekdayDiscountEvent();

    @Test
    @DisplayName("주말 에는 할인 조건을 만족 하지 못한다.")
    void WeekendCase() {
        Date date = Date.of(8);
        Assertions.assertFalse(event.checkCondition(date));
    }

    @Test
    @DisplayName("평일 에는 디저트 개수 * 할인 금액 만큼 할인 받는다.")
    void WeekdayCaseAndOrderMainDish() {
        Date date = Date.of(7);
        List<RequestOrder> requestOrderList = List.of(RequestOrder.of("아이스크림-2"));
        int expectedCount = EventConstant.WEEKDAY_DISCOUNT_PRICE * 2;

        Bill bill = Bill.of(requestOrderList);

        Assertions.assertTrue(event.checkCondition(date));
        Assertions.assertEquals(expectedCount, event.provideReward(bill).discountPrice());
    }

    @Test
    @DisplayName("평일 이라도 디저트 가 없으면 할인을 받지 못한다.")
    void WeekdayCaseAndNotOrderMainDish() {
        Date date = Date.of(7);
        List<RequestOrder> requestOrderList = List.of(RequestOrder.of("크리스마스파스타-2"));

        Bill bill = Bill.of(requestOrderList);

        Assertions.assertTrue(event.checkCondition(date));
        Assertions.assertEquals(0, event.provideReward(bill).discountPrice());
    }
}
