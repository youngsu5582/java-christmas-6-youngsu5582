package christmas.factory;

import christmas.service.BadgeService;
import christmas.service.DateService;
import christmas.service.EventService;
import christmas.service.OrderService;

public class ServiceFactory {
    private static DateService dateService;
    private static OrderService orderService;
    private static BadgeService badgeService;
    private static EventService eventService;

    public static EventService getEventService() {
        if (eventService == null) {
            eventService = new EventService();
        }
        return eventService;
    }

    public static BadgeService getBadgeService() {
        if (badgeService == null) {
            badgeService = new BadgeService();
        }
        return badgeService;
    }

    public static OrderService getOrderService() {
        if (orderService == null) {
            orderService = new OrderService();
        }
        return orderService;
    }

    public static DateService getDateService() {
        if (dateService == null) {
            dateService = new DateService();
        }
        return dateService;
    }
}
