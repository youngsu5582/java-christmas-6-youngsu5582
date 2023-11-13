package christmas.event;

import christmas.domain.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.constant.EventConstant.SPECIAL_DAY_PRICE;

public class SpecialDiscountEventTest {
    SpecialDiscountEvent event = new SpecialDiscountEvent();
    @Test
    @DisplayName("특정 날은 할인액을 받는다.")
    void SpecialDayCase() {
        Date date = Date.of(10);
        Assertions.assertTrue(event.checkCondition(date));
        Assertions.assertEquals(event.provideReward(null), SPECIAL_DAY_PRICE);
    }
    @Test
    @DisplayName("특정 날이 아닌 날은 할인액을 받지 못한다")
    void NotSpecialDayCase(){
        Date date = Date.of(11);
        Assertions.assertFalse(event.checkCondition(date));
    }
}
