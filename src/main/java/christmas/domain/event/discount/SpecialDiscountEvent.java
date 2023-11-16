package christmas.domain.event.discount;

import java.util.List;

import christmas.domain.date.Date;
import christmas.domain.reward.DiscountEventReward;
import christmas.lib.event.DiscountEvent;

import static christmas.constant.EventConstant.SPECIAL_DAY_MESSAGE;
import static christmas.constant.EventConstant.SPECIAL_DAY_PRICE;

public class SpecialDiscountEvent extends DiscountEvent<Void> {
    private final List<Integer> SPECIAL_DAY = List.of(3, 10, 17, 24, 25, 31);
    private final String EVENT_NAME = SPECIAL_DAY_MESSAGE;

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
