package christmas.controller;

import christmas.domain.date.Date;
import christmas.domain.reward.Reward;
import christmas.domain.order.Bill;
import christmas.factory.ServiceFactory;
import christmas.service.EventService;

public class EventController {
    private final EventService eventService = ServiceFactory.getEventService();
    public Reward confirmReward(Date date, Bill bill){
        return eventService.createReward(date,bill);
    }
}
