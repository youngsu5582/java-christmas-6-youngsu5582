package christmas.controller;

import christmas.domain.Date;
import christmas.domain.badge.Badge;
import christmas.domain.event.Reward;
import christmas.domain.order.Bill;
import christmas.dto.RewardDto;
import christmas.view.OutputView;

public class Gamecontroller {
    private final DateController dateController = new DateController();
    private final OrderController orderController = new OrderController();
    private final EventController eventController = new EventController();
    private final BadgeController badgeController = new BadgeController();

    public void run() {
        OutputView.printWelcomeMessage();

        Date date = confirmVisitDate();
        Bill bill = confirmOrder();
        printOrderResult(date, bill);

        Reward reward = checkReward(date, bill);

        printRewardResult(reward.toDto());
        printFinalCheckoutPrice(bill,reward.toDto());

        Badge badge = checkBadge(reward.toDto());
        printBadgeResult(badge);
    }

    public Date confirmVisitDate() {
        Date date = dateController.acceptVisitDate();
        return date;
    }

    public Bill confirmOrder() {
        Bill bill = orderController.acceptOrder();
        return bill;
    }

    public void printOrderResult(Date date, Bill bill) {
        OutputView.printPreviewMessage(date);
        OutputView.printOrderMessage(bill);
    }

    public Reward checkReward(Date date, Bill bill) {
        Reward reward = eventController.confirmReward(date, bill);
        return reward;
    }
    public Badge checkBadge(RewardDto rewardDto){
        Badge badge = badgeController.grantBadge(rewardDto);
        return badge;
    }
    public void printFinalCheckoutPrice(Bill bill,RewardDto rewardDto){

        int checkoutPrice = bill.totalPrice() - rewardDto.getTotalDiscountReward();
        OutputView.printFinalCheckoutPriceMessage(checkoutPrice);
    }

    public void printRewardResult(RewardDto rewardDto) {
        OutputView.printRewardsMessage(rewardDto);
    }
    public void printBadgeResult(Badge badge){
        OutputView.printBadgeMessage(badge);
    }
}
