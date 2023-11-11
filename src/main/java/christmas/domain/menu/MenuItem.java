package christmas.domain.menu;

public abstract interface MenuItem {

    Menu get();

    String getName();

    int getPrice();
}
