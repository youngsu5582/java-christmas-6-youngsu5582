package christmas.domain.reward;

import java.util.ArrayList;
import java.util.List;

import christmas.dto.RewardDto;
import christmas.lib.event.EventReward;

public class Reward {
    private List<DiscountEventReward> discountRewards;
    private List<PresentEventReward> presentRewards;

    public Reward(List<EventReward> eventRewards) {
        this.discountRewards = new ArrayList<>();
        this.presentRewards = new ArrayList<>();
        for (EventReward eventReward : eventRewards) {
            processEventReward(eventReward);
        }
    }

    private void processEventReward(EventReward eventReward) {
        if (eventReward instanceof DiscountEventReward) {
            processDiscountEventReward((DiscountEventReward) eventReward);
        }
        if (eventReward instanceof PresentEventReward) {
            processPresentEventReward((PresentEventReward) eventReward);
        }
    }

    private void processDiscountEventReward(DiscountEventReward discountReward) {
        if (discountReward.discountPrice() != 0) {
            discountRewards.add(discountReward);
        }
    }

    private void processPresentEventReward(PresentEventReward presentReward) {
        presentRewards.add(presentReward);
    }

    public RewardDto toDto() {
        return new RewardDto(calculateTotalRewardPrice(), discountRewards, presentRewards);
    }

    private Integer calculateTotalRewardPrice() {
        return calculateDiscountRewardPrice() + calculatePresentRewardPrice();
    }

    private Integer calculateDiscountRewardPrice() {
        int discountRewardPrice = 0;
        for (DiscountEventReward discountReward : this.discountRewards) {
            discountRewardPrice += discountReward.discountPrice();
        }
        return discountRewardPrice;
    }

    private Integer calculatePresentRewardPrice() {
        int presentRewardPrice = 0;
        for (PresentEventReward presentEventReward : this.presentRewards) {
            presentRewardPrice += presentEventReward.present().price() * presentEventReward.count();
        }
        return presentRewardPrice;
    }

}
