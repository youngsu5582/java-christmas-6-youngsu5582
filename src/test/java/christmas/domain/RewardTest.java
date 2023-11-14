package christmas.domain;

import christmas.domain.category.Drink;
import christmas.domain.reward.DiscountEventReward;
import christmas.domain.reward.PresentEventReward;
import christmas.domain.reward.Reward;
import christmas.lib.event.EventReward;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class RewardTest {

    Reward reward;
    private static final int DISCOUNT_PRICE = 4046;

    @DisplayName("이벤트 보상 들을 통해  Reward 를 만든다.")
    @BeforeEach
    void setUp() {
        List<EventReward> eventRewards = new ArrayList<>();
        DiscountEventReward discountEventReward = new DiscountEventReward("주말 할인", DISCOUNT_PRICE);
        PresentEventReward presentEventReward = new PresentEventReward(Drink.CHAMPAGNE.get(), 1);
        eventRewards.add(discountEventReward);
        eventRewards.add(presentEventReward);
        reward = new Reward(eventRewards);
    }

    @Test
    @DisplayName("보상 들은 종류에 맞게 , 각 배열에 들어간다.")
    void createRewardWithEventRewards() {
        Assertions.assertEquals(reward.toDto().discountRewards().size(), 1);
        Assertions.assertEquals(reward.toDto().presentRewards().size(), 1);
    }

    @Test
    @DisplayName("총 할인 금액을 계산한다.")
    void calculateTotalRewardPrice() {
        Assertions.assertEquals(reward.toDto().totalRewardPrice(),
                DISCOUNT_PRICE + Drink.CHAMPAGNE.get().price());
    }
}

