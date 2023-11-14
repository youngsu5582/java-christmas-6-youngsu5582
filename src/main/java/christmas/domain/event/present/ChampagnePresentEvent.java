package christmas.domain.event.present;

import christmas.domain.reward.PresentEventReward;
import christmas.domain.menu.Menu;
import christmas.lib.event.PresentEvent;

import static christmas.constant.EventConstant.CHAMPAGNE_LIMIT_PRICE;
import static christmas.constant.EventConstant.CHAMPAGNE_PRESENT;

public class ChampagnePresentEvent extends PresentEvent<Void> {
    private static final Menu presentMenu = CHAMPAGNE_PRESENT;

    @Override
    public boolean checkCondition(Integer amount) {
        if (amount >= CHAMPAGNE_LIMIT_PRICE) {
            return true;
        }
        return false;
    }

    @Override
    public PresentEventReward provideReward(Void object) {
        return new PresentEventReward(presentMenu, 1);
    }
}
