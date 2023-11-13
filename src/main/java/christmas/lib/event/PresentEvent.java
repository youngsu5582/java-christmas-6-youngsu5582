package christmas.lib.event;

import christmas.domain.Date;
import christmas.domain.menu.Menu;

public abstract class PresentEvent <T> extends Event<Integer, T> {
    public abstract boolean checkCondition(Integer amount);

    public abstract Object provideReward(T totalPrice);
}
