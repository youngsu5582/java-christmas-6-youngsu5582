package christmas.lib.exception;

public class CustomException extends IllegalArgumentException {
    private static String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public CustomException(String message) {
        super(ERROR_MESSAGE_PREFIX + message);
    }

    public CustomException(String message, Exception exception) {
        super(ERROR_MESSAGE_PREFIX + message, exception);
    }

}
