package christmas.lib.event;

import christmas.domain.Date;

public abstract class DiscountEvent extends Event{

    public abstract boolean checkCondition(Date date);
    public abstract Object provideReward(Object object);
}
