package christmas.util;

import christmas.domain.menu.Menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class MenuCatalogTest {
    @Test
    @DisplayName("음식명을 통해 메뉴를 받는다.")
    void searchMenuWithMenuName() {
        String testMenuName = "초코케이크";

        var menu = MenuCatalog.searchFromMenuName(testMenuName);

        Assertions.assertEquals(menu.getClass(), Menu.class);
        Assertions.assertEquals(menu.name(), "초코케이크");
    }

    @Test
    @DisplayName("없는 음식명을 입력할 시 , null을 반환한다.")
    void returnNullWithNotExistName() {
        String testMenuName = "초코무스탕";

        var menu = MenuCatalog.searchFromMenuName(testMenuName);

        Assertions.assertEquals(MenuCatalog.NONE,menu);
    }

}