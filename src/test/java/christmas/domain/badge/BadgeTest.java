package christmas.domain.badge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.domain.badge.Badge;

import static christmas.constant.BadgeConstant.*;

public class BadgeTest {
    @Test
    @DisplayName("산타 뱃지 기준치 를 만족 하면 산타 뱃지를 제공 한다.")
    void determineSantaBadgeWhenMoreThanTwentyThousandWon() {
        int totalRewardAmount = SANTA_THRESHOLD;
        Badge badge = Badge.determineBadgeByTotalRewardAmount(totalRewardAmount);
        Assertions.assertEquals(badge, Badge.SANTA);
    }

    @Test
    @DisplayName("트리 뱃지 기준치 를 만족 하면 트리 뱃지를 제공 한다.")
    void determineTreeBadgeWhenMoreThanTenThousandWon() {
        int totalRewardAmount = TREE_THRESHOLD;
        Badge badge = Badge.determineBadgeByTotalRewardAmount(totalRewardAmount);
        Assertions.assertEquals(badge, Badge.TREE);
    }

    @Test
    @DisplayName("별 뱃지 기준치 를 만족 하면 별 뱃지를 제공 한다.")
    void determineStarBadgeWhenMoreThanFiveThousandWon() {
        int totalRewardAmount = STAR_THRESHOLD;
        Badge badge = Badge.determineBadgeByTotalRewardAmount(totalRewardAmount);
        Assertions.assertEquals(badge, Badge.STAR);
    }

    @Test
    @DisplayName("모든 기준치 를 만족 못하면 뱃지를 받지 못한다.")
    void determineNoneBadgeWhenLessThanFiveThousandWon() {
        int totalRewardAmount = NON_THRESHOLD;
        Badge badge = Badge.determineBadgeByTotalRewardAmount(totalRewardAmount);
        Assertions.assertEquals(badge, Badge.NONE);
    }

}
