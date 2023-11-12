package christmas.lib.event;

import christmas.domain.Date;

public abstract class PresentEvent <T> extends Event<Integer, T> {

    public abstract Object provideReward(Integer totalPrice);

    public abstract boolean checkCondition(int amount);
}
