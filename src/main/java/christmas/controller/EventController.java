package christmas.controller;

import christmas.domain.date.Date;
import christmas.domain.reward.Reward;
import christmas.domain.order.Bill;
import christmas.service.EventService;

public class EventController {
    private final EventService eventService = new EventService();
    public Reward confirmReward(Date date, Bill bill){
        return eventService.createReward(date,bill);
    }
}
