package christmas.lib.event;

import christmas.domain.date.Date;
import christmas.domain.reward.DiscountEventReward;

public abstract class DiscountEvent<T> extends Event<Date, T, DiscountEventReward> {

    public abstract boolean checkCondition(Date date);

    public abstract DiscountEventReward provideReward(T object);
}
