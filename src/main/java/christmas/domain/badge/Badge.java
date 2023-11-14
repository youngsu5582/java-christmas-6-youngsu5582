package christmas.domain.badge;

import static christmas.constant.BadgeConstant.*;

public enum Badge {
    SANTA("산타", SANTA_THRESHOLD),
    TREE("트리", TREE_THRESHOLD),
    STAR("별", STAR_THRESHOLD),
    NONE("없음", NON_THRESHOLD);

    String badgeName;
    int thresholdAmount;

    Badge(String badgeName, int thresholdAmount) {
        this.badgeName = badgeName;
        this.thresholdAmount = thresholdAmount;
    }

    public static Badge determineBadgeByTotalRewardAmount(int totalRewardAmount) {
        for (Badge badge : Badge.values()) {
            if (totalRewardAmount >= badge.thresholdAmount) {
                return badge;
            }
        }
        return NONE;
    }

    public String getBadgeName() {
        return badgeName;
    }

}
