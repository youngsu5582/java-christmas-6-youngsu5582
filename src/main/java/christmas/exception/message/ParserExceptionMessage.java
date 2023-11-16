package christmas.exception.message;

public enum ParserExceptionMessage {
    NOT_NUMBER("숫자를 입력해주세요");
    private final String message;

    ParserExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
