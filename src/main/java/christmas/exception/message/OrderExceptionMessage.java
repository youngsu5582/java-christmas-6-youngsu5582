package christmas.exception.message;

import static christmas.constant.OrderConstant.MAX_TOTAL_ORDER_COUNT;

public enum OrderExceptionMessage {
    INVALID_FORMAT("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    OVERALL_ORDER_COUNT(String.format("총 주문한 개수가 %d를 초과했습니다!", MAX_TOTAL_ORDER_COUNT)),
    ONLY_DRINK("음료만 주문할 수 없습니다!");

    private final String message;

    OrderExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
