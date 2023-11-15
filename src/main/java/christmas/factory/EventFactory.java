package christmas.factory;

import christmas.domain.event.discount.ChristmasDiscountEvent;
import christmas.domain.event.discount.SpecialDiscountEvent;
import christmas.domain.event.discount.WeekdayDiscountEvent;
import christmas.domain.event.discount.WeekendDiscountEvent;
import christmas.domain.event.present.ChampagnePresentEvent;
import christmas.lib.event.Event;

import java.util.List;

public class EventFactory {
    private static final List<Event> EVENT_LIST;

    static {
        EVENT_LIST = List.of(
                new ChampagnePresentEvent(),
                new SpecialDiscountEvent(),
                new WeekdayDiscountEvent(),
                new WeekendDiscountEvent(),
                new ChristmasDiscountEvent());
    }

    public static List<Event> getEventList() {
        return EVENT_LIST;
    }
}
