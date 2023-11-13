package christmas.event;

import static christmas.constant.EventConstant.SPECIAL_DAY_PRICE;

import christmas.domain.Date;
import christmas.domain.event.DiscountEventReward;
import christmas.lib.event.DiscountEvent;

import java.util.List;

public class SpecialDiscountEvent extends DiscountEvent<Void> {
    private final List<Integer> SPECIAL_DAY = List.of(3, 10, 17, 24, 25, 31);
    private final String EVENT_NAME = "주말 할인";

    @Override
    public boolean checkCondition(Date date) {
        if (SPECIAL_DAY.contains(date.day())) {
            return true;
        }
        return false;
    }

    @Override
    public DiscountEventReward provideReward(Void object) {
        return new DiscountEventReward(EVENT_NAME, SPECIAL_DAY_PRICE);
    }
}
