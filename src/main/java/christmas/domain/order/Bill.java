package christmas.domain.order;

import static christmas.constant.OrderConstant.MAX_TOTAL_ORDER_COUNT;

import christmas.domain.menu.Category;
import christmas.exception.OrderException;
import christmas.exception.message.OrderExceptionMessage;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public record Bill(int totalPrice, EnumMap<Category, List<OrderInfo>> orderDetail) {
    public static Bill of(List<RequestOrder> requestOrderList) {
        EnumMap<Category, List<OrderInfo>> orderMenuBoard = confirmOrders(requestOrderList);

        validate(orderMenuBoard);

        int totalPrice = calculateTotalPrice(orderMenuBoard);
        return new Bill(totalPrice, orderMenuBoard);
    }

    private static EnumMap<Category, List<OrderInfo>> confirmOrders(List<RequestOrder> requestOrderList) {
        EnumMap<Category, List<OrderInfo>> orderMenuBoard = initOrderMenuBoard();
        for (RequestOrder requestOrder : requestOrderList) {
            confirmOrder(requestOrder, orderMenuBoard);
        }
        return orderMenuBoard;

    }

    private static void confirmOrder(RequestOrder requestOrder, EnumMap<Category, List<OrderInfo>> orderMenuBoard) {
        String orderName = requestOrder.orderName();
        int orderAmount = requestOrder.amount();
        OrderResult orderResult = OrderResult.of(orderName, orderAmount);
        orderMenuBoard.get(orderResult.category()).add(orderResult.orderInfo());
    }


    private static EnumMap<Category, List<OrderInfo>> initOrderMenuBoard() {
        EnumMap<Category, List<OrderInfo>> orderMenuBoard = new EnumMap<>(Category.class);
        for (Category category : Category.values()) {
            orderMenuBoard.put(category, new ArrayList<>());
        }
        return orderMenuBoard;
    }

    private static void validate(EnumMap<Category, List<OrderInfo>> orderMenuBoard) {
        int totalAmount = countTotalOrderMenu(orderMenuBoard);
        validateTotalAmountInRange(totalAmount);
        validateMenuIsOnlyDrink(orderMenuBoard.get(Category.DRINK), totalAmount);
    }

    private static void validateTotalAmountInRange(int totalAmount) {
        if (totalAmount > MAX_TOTAL_ORDER_COUNT) {
            throw new OrderException(OrderExceptionMessage.OVERALL_ORDER_COUNT);
        }
    }

    private static void validateMenuIsOnlyDrink(List<OrderInfo> orderDrinks, int totalOrderCount) {
        int drinkOrderCount = countOrderMenus(orderDrinks);
        if (drinkOrderCount == totalOrderCount) {
            throw new OrderException(OrderExceptionMessage.ONLY_DRINK);
        }
    }


    private static Integer countTotalOrderMenu(EnumMap<Category, List<OrderInfo>> orderBoard) {
        int totalOrderCount = 0;
        for (List<OrderInfo> orderInfos : orderBoard.values()) {
            totalOrderCount += countOrderMenus(orderInfos);
        }
        return totalOrderCount;
    }

    private static Integer countOrderMenus(List<OrderInfo> orderInfos) {
        int orderCount = 0;
        for (OrderInfo orderInfo : orderInfos) {
            orderCount += orderInfo.amount();
        }
        return orderCount;
    }

    private static Integer calculateTotalPrice(EnumMap<Category, List<OrderInfo>> orderBoard) {
        int totalPrice = 0;
        for (List<OrderInfo> orderInfos : orderBoard.values()) {
            for (OrderInfo orderInfo : orderInfos) {
                int price = orderInfo.menu().price();
                totalPrice += orderInfo.amount() * price;
            }
        }
        return totalPrice;
    }
}