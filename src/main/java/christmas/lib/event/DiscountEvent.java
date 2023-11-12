package christmas.lib.event;


import christmas.domain.Date;

public abstract class DiscountEvent<T> extends Event<Date, T> {

    public abstract boolean checkCondition(Date date);

    public abstract Object provideReward(T object);
}
