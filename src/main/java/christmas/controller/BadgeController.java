package christmas.controller;

import christmas.domain.badge.Badge;
import christmas.dto.RewardDto;
import christmas.factory.ServiceFactory;
import christmas.service.BadgeService;

public class BadgeController {
    private BadgeService badgeService = ServiceFactory.getBadgeService();

    public Badge grantBadge(RewardDto rewardDto) {
        return this.badgeService.createBadge(rewardDto.totalRewardPrice());
    }
}
