package christmas.domain.event;

import christmas.domain.menu.Menu;
import christmas.lib.event.EventReward;

public class PresentEventReward extends EventReward {
    private final Menu present;
    private final int count;
    public PresentEventReward(Menu present,int count){
        this.present=present;
        this.count=count;
    }
    public Menu present(){
        return this.present;
    }
    public int count(){
        return count;
    }
}
