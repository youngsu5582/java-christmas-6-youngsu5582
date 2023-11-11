package christmas.domain;

import christmas.domain.category.Dessert;
import christmas.domain.menu.Category;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CategoryTest {
    @Test
    @DisplayName("카테고리에 해당 하는 요소를 받는다.")
    void test() {
        Category category = Category.DESERT;
        var items = category.getItemsInCategory();
        Assertions.assertEquals(items.length, Dessert.values().length);
    }

}
