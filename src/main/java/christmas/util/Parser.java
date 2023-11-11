package christmas.util;

import christmas.exception.ParserException;
import christmas.exception.message.ParserExceptionMessage;

public class Parser {
    public static Integer parseInfoToNumber(String info){
        try{
            return Integer.parseInt(info);
        }catch (NumberFormatException exception){
            throw new ParserException(ParserExceptionMessage.NOT_NUMBER);
        }
    }
}
