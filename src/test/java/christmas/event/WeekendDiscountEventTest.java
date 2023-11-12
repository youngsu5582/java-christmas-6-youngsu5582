package christmas.event;

import christmas.constant.EventConstant;
import christmas.domain.Date;
import christmas.domain.order.Bill;
import christmas.domain.order.RequestOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WeekendDiscountEventTest {
    WeekendDiscountEvent event = new WeekendDiscountEvent();
    @Test
    @DisplayName("평일에는 할인 조건을 만족하지 못한다.")
    void WeekdayCase(){
        Date date = Date.of(7);
        Assertions.assertFalse(event.checkCondition(date));
    }
    @Test
    @DisplayName("주말에는 메인 디쉬 개수 * 할인 금액 만큼 할인 받는다.")
    void WeekendCaseAndOrerMainDish(){
        Date date = Date.of(8);
        List<RequestOrder> requestOrderList = List.of(RequestOrder.of("크리스마스파스타-3"));

        Bill bill = Bill.of(requestOrderList);
        WeekendDiscountEvent event = new WeekendDiscountEvent();
        Assertions.assertTrue(event.checkCondition(date));
        Assertions.assertEquals(EventConstant.WEEKEND_DISCOUNT_PRICE*3,event.provideReward(bill));
    }
    @Test
    @DisplayName("주말이라도 메인 디쉬가 없으면 할인을 받지 못한다.")
    void WeekendCaseAndNotOrderMainDish(){
        Date date = Date.of(8);
        List<RequestOrder> requestOrderList = List.of(RequestOrder.of("아이스크림-2"));
        Bill bill = Bill.of(requestOrderList);
        WeekendDiscountEvent event = new WeekendDiscountEvent();
        Assertions.assertTrue(event.checkCondition(date));
        Assertions.assertEquals(0,event.provideReward(bill));
    }
}
