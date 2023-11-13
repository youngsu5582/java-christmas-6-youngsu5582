package christmas.dto;

import christmas.domain.event.DiscountEventReward;
import christmas.domain.event.PresentEventReward;

import java.util.List;

public record RewardDto(int totalRewardPrice, List<DiscountEventReward> discountRewards,
                        List<PresentEventReward> presentRewards) {
}
