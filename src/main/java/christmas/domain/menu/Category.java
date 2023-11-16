package christmas.domain.menu;

import christmas.domain.category.Appetizer;
import christmas.domain.category.Dessert;
import christmas.domain.category.Drink;
import christmas.domain.category.MainDish;

public enum Category {
    APPETIZER(Appetizer.class),
    DESERT(Dessert.class),
    DRINK(Drink.class),
    MAIN_DISH(MainDish.class);

    private Class<? extends MenuItem> categoryType;

    Category(Class<? extends MenuItem> categoryType) {
        this.categoryType = categoryType;
    }

    public MenuItem[] getItemsInCategory() {
        return categoryType.getEnumConstants();
    }
}
