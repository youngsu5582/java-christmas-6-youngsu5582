package christmas.controller;

import christmas.domain.Date;
import christmas.domain.event.Reward;
import christmas.domain.order.Bill;
import christmas.service.EventService;

public class EventController {
    private final EventService eventService = new EventService();
    public Reward confirmReward(Date date, Bill bill){
        return eventService.createReward(date,bill);
    }
}
