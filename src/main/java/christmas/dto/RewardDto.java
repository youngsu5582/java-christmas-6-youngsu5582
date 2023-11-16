package christmas.dto;

import java.util.List;

import christmas.domain.reward.DiscountEventReward;
import christmas.domain.reward.PresentEventReward;

public record RewardDto(int totalRewardPrice, List<DiscountEventReward> discountRewards,
                        List<PresentEventReward> presentRewards) {
    public Integer getTotalDiscountReward() {
        int totalDiscountReward = 0;
        for (DiscountEventReward discountEventReward : discountRewards) {
            totalDiscountReward += discountEventReward.discountPrice();
        }
        return totalDiscountReward;
    }
}
