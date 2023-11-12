
package christmas.util;

import christmas.domain.menu.Category;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuInfo;
import christmas.domain.menu.MenuItem;

public class MenuCatalog {
    private static final MenuInfo NONE = new MenuInfo(null,null);
    public static MenuInfo searchMenuInfoFromMenuName(String menuName) {
        for (Category category : Category.values()) {
            Menu menu = serachFromMenuWithMenuNameAndCategory(menuName, category);
            if (menu != null) {
                return new MenuInfo(category, menu);
            }
        }
        return NONE;
    }

    private static Menu serachFromMenuWithMenuNameAndCategory(String menuName, Category category) {
        for (MenuItem menu : category.getItemsInCategory()) {
            if (menu.getName() == menuName) {
                return menu.get();
            }
        }
        return null;
    }
}
