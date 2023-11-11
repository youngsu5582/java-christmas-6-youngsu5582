package christmas.exception.message;

import static christmas.constant.OrderConstant.MIN_AMOUNT;

public enum OrderExceptionMessage {
    INVALID_AMOUNT(String.format("주문 개수는 %d보다 더 큰 값을 입력해주세요!",MIN_AMOUNT)),
    INVALID_FORMAT("메뉴명을 똑바로 입력해주세요!");
    private final String message;

    OrderExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
