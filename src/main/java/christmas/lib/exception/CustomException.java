package christmas.lib.exception;

public class CustomException extends IllegalArgumentException{
    private static String ERROR_MESSAGE_PREFIX ="[ERROR]";
    public CustomException(String message){
        super(ERROR_MESSAGE_PREFIX+message);
    }
}
