package christmas.service;

import static christmas.constant.EventConstant.EVENT_THRESHOLD_PRICE;
import christmas.domain.Date;
import christmas.domain.event.Reward;
import christmas.domain.order.Bill;
import christmas.event.*;
import christmas.lib.event.DiscountEvent;
import christmas.lib.event.EventReward;
import christmas.lib.event.PresentEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EventService {
    public final List<DiscountEvent> discountEventList;
    public final List<PresentEvent> presentEventList;

    public EventService() {
        this.discountEventList = createDiscountEventList();
        this.presentEventList = createPresentEventList();
    }

    private List<DiscountEvent> createDiscountEventList() {
        return List.of(
                new ChristmasDiscountEvent(),
                new SpecialDiscountEvent(),
                new WeekdayDiscountEvent(),
                new WeekendDiscountEvent());
    }

    private List<PresentEvent> createPresentEventList() {
        return List.of(
                new ChampagnePresentEvent());
    }

    public Reward createReward(Date date, Bill bill) {
        return new Reward(collectTotalReward(date, bill));
    }

    public List<EventReward> collectTotalReward(Date date, Bill bill) {
        if(bill.totalPrice()< EVENT_THRESHOLD_PRICE){
            return new ArrayList<>();
        }
        return Stream.concat(
                collectDiscountReward(date, bill),
                collectPresentReward(bill)
        ).collect(Collectors.toList());
    }

    private Stream<EventReward> collectDiscountReward(Date date, Bill bill) {
        return discountEventList.stream()
                .filter(event -> event.checkCondition(date))
                .map(event -> checkDiscountReward(event, date, bill));
    }

    private Stream<EventReward> collectPresentReward(Bill bill) {
        return presentEventList.stream()
                .filter(event -> event.checkCondition(bill.totalPrice()))
                .map(event -> checkPresentReward(event));
    }

    private EventReward checkPresentReward(PresentEvent event) {
        if (event instanceof ChampagnePresentEvent) {
            return event.provideReward(null);
        }
        return null;
    }

    private EventReward checkDiscountReward(DiscountEvent event, Date date, Bill bill) {
        if (event instanceof SpecialDiscountEvent) {
            return event.provideReward(null);
        }
        if (event instanceof WeekdayDiscountEvent || event instanceof WeekendDiscountEvent) {
            return event.provideReward(bill);
        }
        if (event instanceof ChristmasDiscountEvent) {
            return event.provideReward(date);
        }
        return null;
    }

}