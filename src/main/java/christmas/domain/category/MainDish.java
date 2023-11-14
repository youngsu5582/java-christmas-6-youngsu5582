package christmas.domain.category;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuItem;

public enum MainDish implements MenuItem {
    T_BONE_STAKE("티본스테이크", 55_000),
    BBQ_LIBS("바비큐립", 54_000),
    SEADFOOD_PASTA("해산물파스타", 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000);
    private Menu menu;

    MainDish(String name, int price) {
        this.menu = new Menu(name, price);
    }

    @Override
    public Menu get() {
        return menu;
    }

    public String getName() {
        return menu.name();
    }

}