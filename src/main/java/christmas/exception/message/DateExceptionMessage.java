package christmas.exception.message;

import static christmas.constant.DateConstant.START_DAY;
import static christmas.constant.DateConstant.END_DAY;

public enum DateExceptionMessage {
    INVALID_DAY("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    private final String message;

    DateExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
