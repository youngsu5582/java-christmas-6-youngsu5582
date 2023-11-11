package christmas.domain;

import christmas.exception.DateException;
import christmas.exception.message.DateExceptionMessage;
import christmas.util.Calendar;
import static christmas.constant.DateConstant.START_DAY;
import static christmas.constant.DateConstant.END_DAY;

public record Date(int day, DayOfWeek dayOfWeek) {
    public static Date of(int day){
        validate(day);
        DayOfWeek dayOfWeek = Calendar.calculateDayOfWeek(day);
        return new Date(day,dayOfWeek);
    }
    private static void validate(int day){
        validateDayIsOutRange(day);
    }
    private static void validateDayIsOutRange(int day){
        validateDayIsBelowRange(day);
        validateDayIsExceedRange(day);
    }
    private static void validateDayIsBelowRange(int day){
        if(day<START_DAY){
            throw new DateException(DateExceptionMessage.INVALID_DAY);
        }

    }
    private static void validateDayIsExceedRange(int day){
        if(day>END_DAY){
            throw new DateException(DateExceptionMessage.INVALID_DAY);
        }
    }


}
