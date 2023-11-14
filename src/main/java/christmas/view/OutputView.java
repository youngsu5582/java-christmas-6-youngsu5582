package christmas.view;

import christmas.domain.Date;
import christmas.domain.badge.Badge;
import christmas.domain.event.DiscountEventReward;
import christmas.domain.event.PresentEventReward;
import christmas.domain.menu.Category;
import christmas.domain.order.Bill;
import christmas.domain.order.OrderInfo;
import christmas.dto.RewardDto;
import christmas.util.Formatter;
import christmas.view.message.OutputViewMessage;

import java.util.EnumMap;
import java.util.List;

public class OutputView {
    private static void printNewLine() {
        System.out.println();
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String errorMessage) {
        printMessage(errorMessage);
    }

    public static void printWelcomeMessage() {
        printMessage(OutputViewMessage.WELCOME_MESSAGE.getMessage());
    }

    public static void printPreviewMessage(Date date) {
        printMessage(OutputViewMessage.PREVIEW_MESSAGE.getFormattedMessage(date.day()));
        printNewLine();
    }

    public static void printOrderMessage(Bill bill) {
        printMenuMessage(bill.orderDetail());
        printTotalPriceMessage(bill.totalPrice());
    }

    public static void printRewardsMessage(RewardDto rewardDto) {
        printPresentRewards(rewardDto.presentRewards());
        printRewardMessage(rewardDto);
        printTotalRewardPrice(rewardDto.totalRewardPrice());
    }
    public static void printBadgeMessage(Badge badge){
        printMessage(OutputViewMessage.BADGE_MESSAGE.getMessage());
        printMessage(badge.getBadgeName());
    }
    public static void printFinalCheckoutPriceMessage(int checkoutPrice){
        printMessage(OutputViewMessage.FINAL_PRICE_MESSAGE.getMessage());
        String formattedNumber = Formatter.formatNumber(checkoutPrice);
        printMessage(OutputViewMessage.PRICE_FORMAT.getFormattedMessage(formattedNumber));
        printNewLine();
    }

    private static void printTotalRewardPrice(int totalRewardPrice) {
        printMessage(OutputViewMessage.TOTAL_REWARD_MESSAGE.getMessage());
        String formattedNumber = Formatter.formatBasedOnNumber(totalRewardPrice);
        printMessage(OutputViewMessage.PRICE_FORMAT.getFormattedMessage(formattedNumber));
        printNewLine();
    }

    private static void printPresentRewards(List<PresentEventReward> presentRewards) {
        printMessage(OutputViewMessage.PRESENT_MENU_MESSAGE.getMessage());
        if (presentRewards.isEmpty()) {
            printMessage(OutputViewMessage.NONE.getMessage());
            printNewLine();
            return;
        }
        for (PresentEventReward presentReward : presentRewards) {
            String menuName = presentReward.present().name();
            int count = presentReward.count();
            printMessage(OutputViewMessage.MENU_FORMAT.getFormattedMessage(menuName, count));
        }
        printNewLine();
    }

    private static void printRewardMessage(RewardDto rewardDto) {
        printMessage(OutputViewMessage.REWARD_MESSAGE.getMessage());
        List<DiscountEventReward> discountRewards = rewardDto.discountRewards();
        List<PresentEventReward> presentRewards = rewardDto.presentRewards();

        if (discountRewards.isEmpty() && presentRewards.isEmpty()) {
            printMessage(OutputViewMessage.NONE.getMessage());
            printNewLine();
            return;
        }
        for (DiscountEventReward discountReward : discountRewards) {
            String eventName = discountReward.eventName();
            String FormattedDiscountPrice = Formatter.formatNegativeNumber(discountReward.discountPrice());
            printMessage(OutputViewMessage.EVENT_FORMAT.getFormattedMessage(eventName, FormattedDiscountPrice));
        }
        String FormattedDiscountPrice = Formatter.formatNegativeNumber(calculateTotalPresentPrice(presentRewards));
        printMessage(OutputViewMessage.PRESENT_EVENT_FORMAT.getFormattedMessage(FormattedDiscountPrice));
        printNewLine();
    }

    private static int calculateTotalPresentPrice(List<PresentEventReward> presentRewards) {
        int totalPrice = 0;
        for (PresentEventReward presentReward : presentRewards) {
            totalPrice += presentReward.present().price();
        }
        return totalPrice;
    }

    private static void printMenuMessage(EnumMap<Category, List<OrderInfo>> orderDetail) {
        printMessage(OutputViewMessage.MENU_MESSAGE.getMessage());
        for (List<OrderInfo> orderInfos : orderDetail.values()) {
            for (OrderInfo orderInfo : orderInfos) {
                String orderName = orderInfo.menu().name();
                Integer orderAmount = orderInfo.amount();
                printMessage(OutputViewMessage.MENU_FORMAT.getFormattedMessage(orderName, orderAmount));
            }
        }
        printNewLine();
    }

    private static void printTotalPriceMessage(int totalPrice) {
        printMessage(OutputViewMessage.TOTAL_SALE_MESSAGE.getMessage());
        String formattedPrice = Formatter.formatNumber(totalPrice);
        printMessage(OutputViewMessage.PRICE_FORMAT.getFormattedMessage(formattedPrice));
        printNewLine();
    }


}
