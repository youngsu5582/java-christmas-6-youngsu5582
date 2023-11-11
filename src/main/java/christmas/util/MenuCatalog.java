
package christmas.util;

import christmas.domain.menu.Category;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuItem;

public class MenuCatalog {
    public static Menu NONE = new Menu("",0);
    public static Menu searchFromMenuName(String menuName) {
        for (Category category : Category.values()) {
            for (MenuItem menu : category.getItemsInCategory()) {
                if (menu.getName() == menuName) {
                    return menu.get();
                }
            }
        }
        return null;
    }
}
