package christmas.domain.order;

import christmas.domain.menu.Category;
import christmas.domain.menu.MenuInfo;
import christmas.exception.OrderException;
import christmas.exception.message.OrderExceptionMessage;
import christmas.util.MenuCatalog;

public record OrderResult(Category category, OrderInfo orderInfo) {
    public static OrderResult of(String orderName, int orderAmount) {

        MenuInfo menuInfo = searchMenu(orderName);
        Category category = menuInfo.category();

        validate(menuInfo);
        OrderInfo orderInfo = new OrderInfo(menuInfo.menu(), orderAmount);
        return new OrderResult(category, orderInfo);
    }
    private static void validate(MenuInfo menuInfo){
        validateMenuIsExist(menuInfo);
    }
    private static void validateMenuIsExist(MenuInfo menuInfo){
        if(menuInfo.menu()==null)
            throw new OrderException(OrderExceptionMessage.NOT_EXIST_MENU);
    }

    private static MenuInfo searchMenu(String menuName) {
        return MenuCatalog.searchMenuInfoFromMenuName(menuName);
    }
}
