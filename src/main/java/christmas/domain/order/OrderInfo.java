package christmas.domain.order;

import christmas.domain.menu.Menu;

public record OrderInfo(Menu menu, int amount) {
}
