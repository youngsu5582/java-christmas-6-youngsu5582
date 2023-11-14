package christmas.event;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.constant.EventConstant.CHAMPAGNE_LIMIT_PRICE;
import static christmas.constant.EventConstant.CHAMPAGNE_PRESENT;

public class ChampagnePresentEventTest {
    ChampagnePresentEvent event = new ChampagnePresentEvent();
    @Test
    @DisplayName("특정 금액이 넘으면 샴페인 1개를 증정 받는다.")
    void ChampagnePresentCase() {
        int price = CHAMPAGNE_LIMIT_PRICE;
        Assertions.assertTrue(event.checkCondition(price));
        Assertions.assertEquals(event.provideReward(null).present(), CHAMPAGNE_PRESENT);
        Assertions.assertEquals(event.provideReward(null).count(), 1);
    }
    @Test
    @DisplayName("특정 금액 아래면 증정 받지 못한다.")
    void UnderLimitPriceCase(){
        int underPrice = CHAMPAGNE_LIMIT_PRICE-1;
        Assertions.assertFalse(event.checkCondition(underPrice));
    }
}
