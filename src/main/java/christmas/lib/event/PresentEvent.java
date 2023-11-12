package christmas.lib.event;

import christmas.domain.Date;

public abstract class PresentEvent extends Event{

    public abstract Object provideReward(Object object);
    public abstract boolean checkCondition(int amount);
}
