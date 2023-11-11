package christmas.domain.category;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuItem;

public enum Drink implements MenuItem {
    ZERO_COKE("제로콜라", 3000),
    RED_WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000);
    private Menu menu;

    Drink(String name, int price) {
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

    @Override
    public int getPrice() {
        return menu.price();
    }
}
