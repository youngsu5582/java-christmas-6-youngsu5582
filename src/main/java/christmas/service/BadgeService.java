package christmas.service;

import christmas.domain.badge.Badge;

public class BadgeService {
    public Badge createBadge(int totalRewardPrice) {
        return Badge.determineBadgeByTotalRewardAmount(totalRewardPrice);
    }
}

