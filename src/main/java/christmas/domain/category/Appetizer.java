package christmas.domain.category;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuItem;

public enum Appetizer implements MenuItem {
    MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5000),
    CAESAR_SALAD("시저샐러드", 8000);


    private Menu menu;

    Appetizer(String name, int price) {
        this.menu = new Menu(name, price);
    }
    @Override
    public Menu get(){
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
