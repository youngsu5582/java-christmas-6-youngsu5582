package christmas.event.discount;

import christmas.domain.Date;
import christmas.domain.DayOfWeek;
import christmas.domain.event.DiscountEventReward;
import christmas.domain.menu.Category;
import christmas.domain.order.Bill;
import christmas.domain.order.OrderInfo;
import christmas.lib.event.DiscountEvent;

import java.util.List;

import static christmas.constant.EventConstant.WEEKDAY_DISCOUNT_EVENT_MESSAGE;
import static christmas.constant.EventConstant.WEEKDAY_DISCOUNT_PRICE;

public class WeekdayDiscountEvent extends DiscountEvent<Bill> {
    private final Integer DISCOUNT_PRICE = WEEKDAY_DISCOUNT_PRICE;
    private final String EVENT_NAME = WEEKDAY_DISCOUNT_EVENT_MESSAGE;

    @Override
    public boolean checkCondition(Date date) {
        DayOfWeek dayOfWeek = date.dayOfWeek();
        if (dayOfWeek.isWeekday()) {
            return true;
        }
        return false;
    }

    @Override
    public DiscountEventReward provideReward(Bill bill) {
        List<OrderInfo> orderInfos = bill.orderDetail().get(Category.DESERT);
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
