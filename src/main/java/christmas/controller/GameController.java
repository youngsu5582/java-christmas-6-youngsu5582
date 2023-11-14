package christmas.controller;

import christmas.domain.Date;
import christmas.domain.badge.Badge;
import christmas.domain.event.Reward;
import christmas.domain.order.Bill;
import christmas.dto.RewardDto;
import christmas.view.OutputView;

public class GameController {
    private final DateController dateController = new DateController();
    private final OrderController orderController = new OrderController();
    private final EventController eventController = new EventController();
    private final BadgeController badgeController = new BadgeController();

    public void run() {
        printWelcomeMessage();

        Date date = dateController.acceptVisitDate();
        Bill bill = orderController.acceptOrder();
        printOrderResult(date, bill);

        Reward reward = eventController.confirmReward(date, bill);
        RewardDto rewardDto = reward.toDto();

        printRewardResult(rewardDto);
        printFinalCheckoutPrice(bill, rewardDto);

        printBadgeResult(badgeController.grantBadge(rewardDto));
    }

    public void printWelcomeMessage() {
        OutputView.printWelcomeMessage();
    }

    public void printOrderResult(Date date, Bill bill) {
        OutputView.printPreviewMessage(date);
        OutputView.printOrderMessage(bill);
    }

    public void printFinalCheckoutPrice(Bill bill, RewardDto rewardDto) {

        int checkoutPrice = bill.totalPrice() - rewardDto.getTotalDiscountReward();
        OutputView.printFinalCheckoutPriceMessage(checkoutPrice);
    }

    public void printRewardResult(RewardDto rewardDto) {
        OutputView.printRewardsMessage(rewardDto);
    }

    public void printBadgeResult(Badge badge) {
        OutputView.printBadgeMessage(badge);
    }
}
