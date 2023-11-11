package christmas.exception.message;

public enum DayOfWeekExceptionMessage {
    INVALID_VALUE("나올수 없는 값입니다!");
    private final String message;

    DayOfWeekExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
