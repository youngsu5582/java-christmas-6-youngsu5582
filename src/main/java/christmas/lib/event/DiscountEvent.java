package christmas.lib.event;


import christmas.domain.Date;
import christmas.domain.event.DiscountEventReward;

public abstract class DiscountEvent<T> extends Event<Date, T,DiscountEventReward> {

    public abstract boolean checkCondition(Date date);

    public abstract DiscountEventReward provideReward(T object);
}
