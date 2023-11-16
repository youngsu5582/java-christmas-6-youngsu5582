package christmas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import christmas.domain.date.Date;
import christmas.domain.event.InProgressEventList;
import christmas.domain.reward.Reward;
import christmas.domain.order.Bill;

import christmas.domain.event.discount.ChristmasDiscountEvent;
import christmas.domain.event.discount.SpecialDiscountEvent;
import christmas.domain.event.discount.WeekdayDiscountEvent;
import christmas.domain.event.discount.WeekendDiscountEvent;
import christmas.domain.event.present.ChampagnePresentEvent;

import christmas.factory.EventFactory;
import christmas.lib.event.DiscountEvent;
import christmas.lib.event.EventReward;
import christmas.lib.event.PresentEvent;

import static christmas.constant.EventConstant.EVENT_THRESHOLD_PRICE;

public class EventService {
    private final InProgressEventList eventList;

    public EventService() {
        eventList = InProgressEventList.of(EventFactory.getEventList());
    }

    public Reward createReward(Date date, Bill bill) {
        List<EventReward> eventRewards = collectEventReward(date, bill);
        return new Reward(eventRewards);
    }

    public List<EventReward> collectEventReward(Date date, Bill bill) {
        if (bill.totalPrice() < EVENT_THRESHOLD_PRICE) {
            return new ArrayList<>();
        }
        return Stream.concat(
                collectDiscountReward(date, bill),
                collectPresentReward(bill)
        ).collect(Collectors.toList());
    }

    private Stream<EventReward> collectDiscountReward(Date date, Bill bill) {
        return eventList.discountEventList().stream()
                .filter(event -> event.checkCondition(date))
                .map(event -> checkDiscountReward(event, date, bill));
    }

    private Stream<EventReward> collectPresentReward(Bill bill) {
        return eventList.presentEventList().stream()
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
