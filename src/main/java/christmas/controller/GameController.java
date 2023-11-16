package christmas.controller;

import christmas.domain.date.Date;
import christmas.domain.badge.Badge;
import christmas.domain.reward.Reward;
import christmas.domain.order.Bill;
import christmas.dto.RewardDto;
import christmas.factory.ControllerFactory;
import christmas.view.OutputView;

public class GameController {
    private final DateController dateController = ControllerFactory.getDateController();
    private final OrderController orderController = ControllerFactory.getOrderController();
    private final EventController eventController = ControllerFactory.getEventController();
    private final BadgeController badgeController = ControllerFactory.getBadgeController();

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
