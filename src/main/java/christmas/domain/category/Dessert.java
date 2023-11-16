package christmas.domain.category;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuItem;

public enum Dessert implements MenuItem {
    CHOCO_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);

    private Menu menu;

    Dessert(String name, int price) {
        this.menu = new Menu(name, price);
    }

    @Override
    public Menu get() {
        return menu;
    }

    @Override
    public String getName() {
        return menu.name();
    }


}
