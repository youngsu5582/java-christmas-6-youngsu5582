package christmas.lib.event;

import christmas.domain.event.PresentEventReward;

public abstract class PresentEvent <T> extends Event<Integer, T, PresentEventReward> {
    public abstract boolean checkCondition(Integer amount);

    public abstract PresentEventReward provideReward(T totalPrice);
}
