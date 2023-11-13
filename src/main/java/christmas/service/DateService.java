package christmas.service;

import christmas.domain.Date;
import christmas.util.Parser;

public class DateService {
    public Date createDate(String dayInfo){
            Integer day = Parser.parseInfoToNumber(dayInfo);
            Date date = Date.of(day);
            return date;
    }
}
