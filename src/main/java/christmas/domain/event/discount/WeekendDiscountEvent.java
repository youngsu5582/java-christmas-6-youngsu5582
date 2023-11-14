package christmas.domain.event.discount;

import static christmas.constant.EventConstant.WEEKEND_DISCOUNT_EVENT_MESSAGE;
import static christmas.constant.EventConstant.WEEKEND_DISCOUNT_PRICE;

import christmas.domain.date.Date;
import christmas.domain.date.DayOfWeek;
import christmas.domain.reward.DiscountEventReward;
import christmas.domain.menu.Category;
import christmas.domain.order.Bill;
import christmas.domain.order.OrderInfo;
import christmas.lib.event.DiscountEvent;

import java.util.List;

public class WeekendDiscountEvent extends DiscountEvent<Bill> {
    private final Integer DISCOUNT_PRICE = WEEKEND_DISCOUNT_PRICE;
    private final String EVENT_NAME = WEEKEND_DISCOUNT_EVENT_MESSAGE;

    @Override
    public boolean checkCondition(Date date) {
        DayOfWeek dayOfWeek = date.dayOfWeek();
        if (dayOfWeek.isWeekend()) {
            return true;
        }
        return false;
    }

    @Override
    public DiscountEventReward provideReward(Bill bill) {
        List<OrderInfo> orderInfos = bill.orderDetail().get(Category.MAIN_DISH);
        Integer count = countOrderMenu(orderInfos);
        return new DiscountEventReward(EVENT_NAME, count * DISCOUNT_PRICE);
    }

    private int countOrderMenu(List<OrderInfo> orderInfos) {
        int count = 0;
        for (OrderInfo orderInfo : orderInfos) {
            count += orderInfo.amount();
        }
        return count;
    }
}
