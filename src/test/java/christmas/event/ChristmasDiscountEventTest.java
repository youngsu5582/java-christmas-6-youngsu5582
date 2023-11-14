package christmas.event;

import static christmas.constant.EventConstant.D_DAY_START_PRICE;
import static christmas.constant.EventConstant.CHRISTMAS_DAY;

import christmas.domain.Date;
import christmas.event.discount.ChristmasDiscountEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChristmasDiscountEventTest {
    ChristmasDiscountEvent event = new ChristmasDiscountEvent();

    @Test
    @DisplayName("1일부터 크리스마스 까지 할인액은 늘어난다.")
    void WeekendCase() {
        Date date = Date.of(8);
        Assertions.assertTrue(event.checkCondition(date));
        Assertions.assertNotEquals(event.provideReward(date).discountPrice(), D_DAY_START_PRICE);
    }

    @Test
    @DisplayName("25일 지나면 할인 조건을 만족하지 못한다.")
    void Temp() {
        Date date = Date.of(CHRISTMAS_DAY + 1);
        Assertions.assertFalse(event.checkCondition(date));
    }
}
