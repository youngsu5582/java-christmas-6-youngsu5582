package christmas.event;

import static christmas.constant.EventConstant.D_DAY_DISCOUNT_UNIT;
import static christmas.constant.EventConstant.D_DAY_START_PRICE;
import static christmas.constant.EventConstant.CHRISTMAS_DAY;

import christmas.domain.Date;
import christmas.lib.event.DiscountEvent;

public class ChristmasDiscountEvent extends DiscountEvent<Date> {
    private final Integer D_DAY = CHRISTMAS_DAY;
    private final Integer START_PRICE = D_DAY_START_PRICE;
    private final Integer DISCOUNT_UNIT = D_DAY_DISCOUNT_UNIT;

    @Override
    public boolean checkCondition(Date date) {
        if (date.day() <= D_DAY) {
            return true;
        }
        return false;
    }

    @Override
    public Integer provideReward(Date date) {
        int currentDay = date.day();
        return START_PRICE + (currentDay - 1) * DISCOUNT_UNIT;
    }
}
