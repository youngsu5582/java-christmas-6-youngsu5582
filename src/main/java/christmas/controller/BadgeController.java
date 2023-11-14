package christmas.controller;

import christmas.domain.badge.Badge;
import christmas.dto.RewardDto;
import christmas.service.BadgeService;

public class BadgeController {
    private BadgeService badgeService= new BadgeService();
    public Badge grantBadge(RewardDto rewardDto){
        return this.badgeService.createBadge(rewardDto.totalRewardPrice());
    }
}
