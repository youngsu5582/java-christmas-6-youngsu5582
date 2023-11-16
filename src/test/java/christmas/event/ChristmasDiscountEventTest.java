package christmas.event;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.domain.date.Date;
import christmas.domain.event.discount.ChristmasDiscountEvent;
import org.junit.jupiter.api.Assertions;

import static christmas.constant.EventConstant.D_DAY_START_PRICE;
import static christmas.constant.EventConstant.CHRISTMAS_DAY;

public class ChristmasDiscountEventTest {
    ChristmasDiscountEvent event = new ChristmasDiscountEvent();

    @Test
    @DisplayName("1일부터 크리스마스 까지 할인액은 늘어난다.")
    void ChristmasDayInCase() {
        Date date = Date.of(8);
        Assertions.assertTrue(event.checkCondition(date));
        Assertions.assertNotEquals(event.provideReward(date).discountPrice(), D_DAY_START_PRICE);
    }

    @Test
    @DisplayName("25일 지나면 할인 조건을 만족하지 못한다.")
    void ChristmasDayOverCase() {
        Date date = Date.of(CHRISTMAS_DAY + 1);
        Assertions.assertFalse(event.checkCondition(date));
    }
}
