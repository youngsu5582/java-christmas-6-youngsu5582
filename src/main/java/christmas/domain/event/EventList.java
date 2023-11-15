package christmas.domain.event;

import christmas.lib.event.DiscountEvent;
import christmas.lib.event.Event;
import christmas.lib.event.PresentEvent;

import java.util.ArrayList;
import java.util.List;

public record EventList(List<DiscountEvent> discountEventList,
                        List<PresentEvent> presentEventList) {
    public static EventList of(List<Event> eventList) {
        List<DiscountEvent> discountEventList = new ArrayList<>();
        List<PresentEvent> presentEventList = new ArrayList<>();
        for (Event event : eventList) {
            if (event instanceof DiscountEvent) {
                discountEventList.add((DiscountEvent) event);
            }
            if (event instanceof PresentEvent) {
                presentEventList.add((PresentEvent) event);
            }
        }
        return new EventList(discountEventList, presentEventList);
    }
}
