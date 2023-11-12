package christmas.util;

import christmas.domain.menu.Menu;

import christmas.domain.menu.MenuInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class MenuCatalogTest {
    @Test
    @DisplayName("음식명을 통해 메뉴 정보를 받는다.")
    void searchMenuWithMenuName() {
        String testMenuName = "초코케이크";

        var menuInfo = MenuCatalog.searchMenuInfoFromMenuName(testMenuName);

        Assertions.assertEquals(menuInfo.getClass(), MenuInfo.class);
        Assertions.assertEquals(menuInfo.menu().name(), "초코케이크");
    }

    @Test
    @DisplayName("없는 음식명을 입력할 시 , null을 반환한다.")
    void returnNullWithNotExistName() {
        String testMenuName = "초코무스탕";

        var menuInfo = MenuCatalog.searchMenuInfoFromMenuName(testMenuName);

        Assertions.assertNull(menuInfo.category());
        Assertions.assertNull(menuInfo.menu());
    }

}