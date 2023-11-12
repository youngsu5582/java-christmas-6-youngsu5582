package christmas.exception.message;

import static christmas.constant.OrderConstant.MIN_AMOUNT;
import static christmas.constant.OrderConstant.MAX_TOTAL_ORDER_COUNT;

public enum OrderExceptionMessage {
    INVALID_AMOUNT(String.format("주문 개수는 %d보다 더 큰 값을 입력해주세요!", MIN_AMOUNT)),
    INVALID_FORMAT("메뉴명을 똑바로 입력해주세요!"),
    DUPLICATE_MENU("중복된 메뉴명이 있습니다!"),
    NOT_EXIST_MENU("없는 메뉴명입니다!"),
    OVERALL_ORDER_COUNT(String.format("총 주문한 개수가 %d를 초과했습니다!", MAX_TOTAL_ORDER_COUNT)),
    ONLY_DRINK("음료만 주문할 수 없습 니다!");

    private final String message;

    OrderExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
