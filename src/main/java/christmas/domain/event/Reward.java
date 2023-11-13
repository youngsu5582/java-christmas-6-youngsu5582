package christmas.domain.event;

import christmas.dto.RewardDto;
import christmas.lib.event.EventReward;

import java.util.ArrayList;
import java.util.List;

public class Reward {
    private List<DiscountEventReward> discountRewards;
    private List<PresentEventReward> presentRewards;

    public Reward(List<EventReward> eventRewards) {
        this.discountRewards = new ArrayList<>();
        this.presentRewards = new ArrayList<>();
        for (EventReward eventReward : eventRewards) {
            if (eventReward instanceof DiscountEventReward) {
                discountRewards.add((DiscountEventReward) eventReward);
            }
            if (eventReward instanceof PresentEventReward) {
                presentRewards.add((PresentEventReward) eventReward);
            }
        }
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
