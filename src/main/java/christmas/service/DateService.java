package christmas.service;

import christmas.domain.Date;
import christmas.exception.DateException;
import christmas.exception.ParserException;
import christmas.exception.message.DateExceptionMessage;
import christmas.util.Parser;

public class DateService {
    public Date createDate(String dayInfo) {
        try {
            int day = Parser.parseInfoToNumber(dayInfo);
            Date date = Date.of(day);
            return date;
        }catch (ParserException exception){
            throw new DateException(DateExceptionMessage.INVALID_DAY);
        }
    }
}
