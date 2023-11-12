package christmas.event;

import static christmas.constant.EventConstant.WEEKEND_DISCOUNT_PRICE;

import christmas.domain.Date;
import christmas.domain.DayOfWeek;
import christmas.domain.menu.Category;
import christmas.domain.order.Bill;
import christmas.domain.order.OrderInfo;
import christmas.lib.event.DiscountEvent;

import java.util.List;

public class WeekendDiscountEvent extends DiscountEvent<Bill> {
    private final Integer DISCOUNT_PRICE = WEEKEND_DISCOUNT_PRICE;

    @Override
    public boolean checkCondition(Date date) {
        DayOfWeek dayOfWeek = date.dayOfWeek();
        if (dayOfWeek.isWeekend()) {
            return true;
        }
        return false;
    }

    @Override
    public Integer provideReward(Bill bill) {
        List<OrderInfo> orderInfos = bill.orderDetail().get(Category.MAIN_DISH);
        Integer count = countOrderMenu(orderInfos);
        return count * DISCOUNT_PRICE;
    }

    private int countOrderMenu(List<OrderInfo> orderInfos) {
        int count = 0;
        for (OrderInfo orderInfo : orderInfos) {
            count += orderInfo.amount();
        }
        return count;
    }
}
