package christmas.util;

import java.util.Arrays;
import java.util.List;

import christmas.exception.ParserException;
import christmas.exception.message.ParserExceptionMessage;

public class Parser {
    public static Integer parseInfoToNumber(String info) {
        try {
            return Integer.parseInt(info);
        } catch (NumberFormatException exception) {
            throw new ParserException(ParserExceptionMessage.NOT_NUMBER);
        }
    }

    public static List<String> parseInfoWithSeparator(String info, String separator) {
        return Arrays.asList(info.split(separator));
    }
}
