package christmas.exception.message;

import static christmas.constant.DateConstant.START_DAY;
import static christmas.constant.DateConstant.END_DAY;

public enum DateExceptionMessage {
    INVALID_DAY(String.format("%d에서 %d사이의 날짜를 입력해주세요!",START_DAY,END_DAY));
    private final String message;

    DateExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
