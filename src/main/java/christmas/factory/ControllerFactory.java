package christmas.factory;

import christmas.controller.*;

public class ControllerFactory {
    private static GameController gameController;
    private static BadgeController badgeController;
    private static EventController eventController;
    private static OrderController orderController;
    private static DateController dateController;

    public static GameController getGameController() {
        if (gameController == null) {
            gameController = new GameController();
        }
        return gameController;
    }

    public static BadgeController getBadgeController() {
        if (badgeController == null) {
            badgeController = new BadgeController();
        }
        return badgeController;
    }

    public static OrderController getOrderController() {
        if (orderController == null) {
            orderController = new OrderController();
        }
        return orderController;
    }

    public static DateController getDateController() {
        if (dateController == null) {
            dateController = new DateController();
        }
        return dateController;
    }

    public static EventController getEventController() {
        if (eventController == null) {
            eventController = new EventController();
        }
        return eventController;
    }
}
