package christmas.domain.event;

import christmas.domain.menu.Menu;
import christmas.lib.event.EventReward;

public class DiscountEventReward extends EventReward {
    private final String eventName;
    private final int discountPrice;
    public DiscountEventReward(String eventName, int discountPrice){
        this.eventName=eventName;
        this.discountPrice=discountPrice;
    }
    public String eventName(){
        return this.eventName;
    }
    public int discountPrice(){
        return discountPrice;
    }
}
