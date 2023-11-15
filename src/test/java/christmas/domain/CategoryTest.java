package christmas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.domain.category.Dessert;
import christmas.domain.menu.Category;

public class CategoryTest {
    @Test
    @DisplayName("카테고리에 해당 하는 요소를 받는다.")
    void getItemInSpecificCategory() {
        Category category = Category.DESERT;
        var items = category.getItemsInCategory();
        Assertions.assertEquals(items.length, Dessert.values().length);
    }

}
