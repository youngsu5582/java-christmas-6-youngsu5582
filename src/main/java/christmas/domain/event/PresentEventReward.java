package christmas.domain.event;

import christmas.domain.menu.Menu;

public record PresentEventReward(Menu present , int count) {
}
