package christmas.view;

import christmas.domain.Date;
import christmas.domain.menu.Category;
import christmas.domain.order.Bill;
import christmas.domain.order.OrderInfo;
import christmas.view.message.OutputViewMessage;

import java.text.NumberFormat;
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
        String formattedPrice = formatNumber(totalPrice);
        printMessage(OutputViewMessage.PRICE_FORMAT.getFormattedMessage(formattedPrice));
        printNewLine();
    }

    private static String formatNumber(int number) {
        NumberFormat formatter = NumberFormat.getInstance();
        return formatter.format(number);
    }

}
